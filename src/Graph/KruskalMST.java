package Graph;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.UF;

public class KruskalMST {
    private double weight;
    private Queue<Edge> mst;
    public KruskalMST(EdgeWeightGraph g){
        mst = new Queue<>();
        MinPQ<Edge> pq = new MinPQ<>();
        UF uf = new UF(g.V());
        while (!pq.isEmpty()&&mst.size()<g.V()-1){
            Edge e = pq.delMin();
            int v = e.either(), w = e.other(v);
            if(uf.connected(v,w)){
                continue;
            }
            uf.union(v,w);
            mst.enqueue(e);
            weight+=e.weight();
        }

    }

    public Iterable<Edge> edges(){
        return mst;
    }

    public double weight(){
        return weight;
    }
}
