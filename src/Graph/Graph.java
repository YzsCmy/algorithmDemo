package Graph;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

public class Graph {
    private final int V;
    private int E;
    private Bag<Integer>[] adj;
    public Graph(int v){
        this.V = v;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new Bag<>();
        }
    }

    public Graph(In in){
        this(in.readInt());
        int e = in.readInt();
        for (int i = 0; i < e; i++){
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v,w);
        }
    }

    public static int degree(Graph g,int v){
        int degree = 0;
        for (int w:g.adj(v)) {
            degree++;
        }
        return degree;
    }

    public static int maxDegree(Graph g){
        int max = 0;
        for (int i = 0; i < g.V(); i++) {
            max = degree(g,i)>max?degree(g,i):max;
        }
        return max;
    }

    public static int avgDegree(Graph g){
        return 2*g.E()/g.V();
    }

    public static int numOfSelfLoops(Graph g){
        int count = 0;
        for (int i = 0; i < g.V(); i++) {
            for(int w:g.adj(i)){
                if(w==i){
                    count++;
                }

            }
        }
        return count/2;
    }

    public int V(){
        return this.V;
    }

    public int E(){
        return this.E;
    }

    public void addEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
        this.E++;
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

