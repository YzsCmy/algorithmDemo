package Graph;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;

public class LazyPrimMST {
    private boolean[] marked;
    private Queue<Edge> mst;
    private MinPQ<Edge> pq;

    public LazyPrimMST(EdgeWeightGraph g){
        marked = new boolean[g.V()];
        mst = new Queue<>();
        pq = new MinPQ<>();
        visit(g,0);
        while (!pq.isEmpty()){
            Edge s = pq.delMin();
            int v = s.either(), w = s.other(v);
            if(marked[v]&&marked[w]){
                continue;
            }
            mst.enqueue(s);
            if(!marked[v]){
                visit(g,v);
            }
            if(!marked[w]){
                visit(g,w);
            }
        }
    }

    private void visit(EdgeWeightGraph g,int v){
        marked[v] = true;
        for(Edge w:g.adj(v)){
            if(!marked[w.other(v)]){
                pq.insert(w);
            }
        }

    }

    public Iterable<Edge> edges(){
        return mst;
    }

    public double weight(){
        double w=0;
        for(Edge e:mst){
            w+=e.weight();
        }
        return w;
    }

}
