package Graph;

import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.Stack;

public class DijkstraSP {
    private double[] distTo;
    private DirectedEdge[] edgeTo;
    private IndexMinPQ<Double> pq;

    public DijkstraSP(EdgeWeightDigraph g, int s){

        distTo = new double[g.V()];
        edgeTo = new DirectedEdge[g.V()];
        pq = new IndexMinPQ<>(g.V());
        for (int i = 0; i < g.V(); i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0.0;
        pq.insert(s,distTo[s]);
        while (!pq.isEmpty()){
            relax(g,pq.delMin());
        }
    }

    private void relax(EdgeWeightDigraph g,int v){
        for(DirectedEdge e:g.adj(v)){
            int w = e.to();
            if(distTo[w]>distTo[v]+e.weight()){
                distTo[w] = distTo[v]+e.weight();
                edgeTo[w] = e;
                if(pq.contains(w)){
                    pq.changeKey(w,distTo[w]);
                }else{
                    pq.insert(w,distTo[w]);
                }
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
