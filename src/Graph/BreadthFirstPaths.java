package Graph;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class BreadthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    public BreadthFirstPaths(Graph g,int v){
        marked = new boolean[g.V()];
        edgeTo = new int[g.V()];
        this.s = v;
        bfs(g,v);
    }

    private void bfs(Graph g,int v){
        Queue<Integer> ver = new Queue<>();
        marked[v] = true;
        ver.enqueue(v);
        while (!ver.isEmpty()){
            v = ver.dequeue();
            for(int w:g.adj(v)){
                if(!marked[w]){
                    edgeTo[w] = v;
                    marked[w] = true;
                    ver.enqueue(w);
                }
            }
        }

    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v){
        if(!hasPathTo(v)){
            return null;
        }
        Stack<Integer> path = new Stack<>();
        for(int x = v; x != s; x=edgeTo[x]){
            path.push(x);
        }
        path.push(s);
        return path;
    }
}
