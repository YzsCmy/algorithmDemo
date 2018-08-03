package Graph;

import edu.princeton.cs.algs4.Stack;

public class DepthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    public DepthFirstPaths(Graph g, int s){
        marked = new boolean[g.V()];
        edgeTo = new int[g.V()];
        this.s = s;
        dfs(g,s);
    }

    private void dfs(Graph g,int v){
        marked[v] = true;
        for(int m : g.adj(v)){
            if(!marked[m]){
                edgeTo[m] = v;
                dfs(g,m);
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
