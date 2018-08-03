package Graph;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.IndexMinPQ;

public class PrimMST {
    private Edge[] edgeTo;
    private double[] distTo;
    private boolean[] marked;
    private IndexMinPQ<Double> pq;

    public PrimMST(EdgeWeightGraph g){
        edgeTo = new Edge[g.V()];
        distTo = new double[g.V()];
        marked = new boolean[g.V()];

        for (int i = 0; i < g.V(); i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        pq = new IndexMinPQ<>(g.V());
        distTo[0] = 0.0;
        while (!pq.isEmpty()){
            visit(g,pq.delMin());
        }
    }

    private void visit(EdgeWeightGraph g,int v){
        marked[v] = true;
        for(Edge e:g.adj(v)){
            int w = e.other(v);
            if(!marked[w]){
                continue;
            }
            if(e.weight()<distTo[w]){
                edgeTo[w] = e;
                distTo[w] = e.weight();

                if(pq.contains(w)){
                    pq.changeKey(w,distTo[w]);
                }else{
                    pq.insert(w,distTo[w]);
                }
            }
        }
    }

    public Iterable<Edge> edges(){
        Bag<Edge> bag = new Bag<>();
        for (int i = 1; i < edgeTo.length; i++) {
            bag.add(edgeTo[i]);
        }
        return bag;
    }

    public double weight(){
        double num = 0.0;
        for (int i = 0; i < distTo.length; i++) {
            num+=distTo[i];
        }
        return num;
    }
}
