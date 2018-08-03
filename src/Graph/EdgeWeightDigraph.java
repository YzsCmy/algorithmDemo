package Graph;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

public class EdgeWeightDigraph {
    private final int V;
    private int E;
    private Bag<DirectedEdge>[] adj;
    public EdgeWeightDigraph(int v){
        this.V = v;
        this.E = 0;
        adj = (Bag<DirectedEdge>[]) new Bag[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new Bag<>();
        }
    }

    public EdgeWeightDigraph(In in){
        this(in.readInt());
        int e = in.readInt();
        for (int i = 0; i < e; i++){
            int v = in.readInt();
            int w = in.readInt();
            double weight = in.readDouble();
            addEdge(new DirectedEdge(v,w,weight));
        }
    }

    public int V(){
        return this.V;
    }

    public int E(){
        return this.E;
    }

    public void addEdge(DirectedEdge e){
        int v = e.from();
        adj[v].add(e);
        this.E++;
    }

    public Iterable<DirectedEdge> adj(int v){
        return adj[v];
    }

    public Iterable<DirectedEdge> edges(){
        Bag<DirectedEdge> bag = new Bag<>();
        for (int i = 0; i < V; i++) {
            for(DirectedEdge e:adj[i]){
                bag.add(e);
            }
        }
        return bag;
    }


}
