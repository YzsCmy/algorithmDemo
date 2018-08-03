package Graph;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

public class Digraph {

    private final int V;
    private int E;
    private Bag<Integer>[] adj;
    public Digraph(int v){
        this.V = v;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new Bag<>();
        }
    }

    public Digraph(In in){
        this(in.readInt());
        int e = in.readInt();
        for (int i = 0; i < e; i++){
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v,w);
        }
    }


    public int V(){
        return this.V;
    }

    public int E(){
        return this.E;
    }

    public void addEdge(int v, int w){
        adj[v].add(w);
        this.E++;
    }

    public Digraph reverse(){
        Digraph digraph = new Digraph(this.V());
        for (int i = 0; i < this.V(); i++) {
            for(int w:this.adj(i)){
                digraph.addEdge(w,i);
            }
        }
        return digraph;
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(this.V + " vertices, " + this.E + " edges\n");

        for(int v = 0; v < this.V; ++v) {
            s.append(v + ": ");
            for(int w: this.adj(v)){
                s.append(w + " ");
            }
            s.append("/n");
        }
        return s.toString();
    }
}
