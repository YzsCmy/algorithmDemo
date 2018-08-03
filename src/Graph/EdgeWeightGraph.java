package Graph;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

public class EdgeWeightGraph {
    private final int V;
    private int E;
    private Bag<Edge>[] adj;
    public EdgeWeightGraph(int v){
        this.V = v;
        this.E = 0;
        adj = (Bag<Edge>[]) new Bag[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new Bag<>();
        }
    }

    public EdgeWeightGraph(In in){
        this(in.readInt());
        int e = in.readInt();
        for (int i = 0; i < e; i++){
            int v = in.readInt();
            int w = in.readInt();
            double weight = in.readDouble();
            addEdge(new Edge(v,w,weight));
        }
    }

    public int V(){
        return this.V;
    }

    public int E(){
        return this.E;
    }

    public void addEdge(Edge e){
        int v = e.either(), w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        this.E++;
    }

    public Iterable<Edge> adj(int v){
        return adj[v];
    }

    public Iterable<Edge> edges(){
        Bag<Edge> bag = new Bag<>();
        for (int i = 0; i < V; i++) {
            for(Edge e:adj[i]){
                if(e.other(i)>i){
                    bag.add(e);
                }
            }
        }
        return bag;
    }

}
