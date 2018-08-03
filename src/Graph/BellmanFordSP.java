package Graph;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class BellmanFordSP {

    private double[] distTo;
    private DirectedEdge[] edgeTo;
    private boolean[] onQ;
    private int cost;
    private Queue<Integer> queue;

    private Iterable<DirectedEdge> cycle;

    public BellmanFordSP(EdgeWeightDigraph g,int s){
        distTo = new double[g.V()];
        edgeTo = new DirectedEdge[g.V()];
        onQ = new boolean[g.V()];
        queue = new Queue<>();
        for (int i = 0; i < g.V(); i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0.0;
        queue.enqueue(s);
        onQ[s] = true;
        while (!queue.isEmpty()&&!hasNegativeCycle()){
            int v = queue.dequeue();
            onQ[v] = false;
            relax(g,v);
        }
    }

    private void relax(EdgeWeightDigraph g,int v){
        for(DirectedEdge e:g.adj(v)){
            int w = e.to();
            if(distTo[w]>distTo[v]+e.weight()){
                distTo[w] = distTo[v]+e.weight();
                edgeTo[w] = e;
                if(!onQ[w]){
                    queue.enqueue(w);
                    onQ[w] = true;
                }
            }
            if(cost++ % g.V()==0){
                findNegativeCycle();
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

    private void findNegativeCycle(){
        int v = edgeTo.length;
        EdgeWeightDigraph g = new EdgeWeightDigraph(v);
        for (int i = 0; i < v; i++) {
            if(edgeTo[i]!=null){
                g.addEdge(edgeTo[i]);
            }
        }
        EdgeWeightDirectedcycle finder = new EdgeWeightDirectedcycle(g);
        this.cycle = finder.cycle();
    }

    public boolean hasNegativeCycle(){
        return cycle!=null;
    }

    public Iterable<DirectedEdge> getCycle() {
        return cycle;
    }
}
