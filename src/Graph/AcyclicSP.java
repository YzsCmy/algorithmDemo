package Graph;

import edu.princeton.cs.algs4.Stack;

public class AcyclicSP {
    private double[] distTo;
    private DirectedEdge[] edgeTo;

    public AcyclicSP(EdgeWeightDigraph g, int s){

        distTo = new double[g.V()];
        edgeTo = new DirectedEdge[g.V()];
        for (int i = 0; i < g.V(); i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0.0;
        DepthFirstOrder order = new DepthFirstOrder(g);
        for(int v:order.reversePost()){
            relax(g,v);
        }
    }

    private void relax(EdgeWeightDigraph g,int v){
        for(DirectedEdge e:g.adj(v)){
            int w = e.to();
            if(distTo[w]>distTo[v]+e.weight()){
                distTo[w] = distTo[v]+e.weight();
                edgeTo[w] = e;
            }

        }
    }

    public double distTo(int v){
        return distTo[v];
    }

    public boolean hasPathTo(int v){
        return distTo[v]<Double.POSITIVE_INFINITY;
    }

    public Iterable<DirectedEdge> pathTo(int v){
        if(!hasPathTo(v)){
            return null;
        }
        Stack<DirectedEdge> stack = new Stack<>();
        for (DirectedEdge e=edgeTo[v];e!=null;e=edgeTo[e.from()]) {
            stack.push(e);
        }
        return stack;
    }
}
