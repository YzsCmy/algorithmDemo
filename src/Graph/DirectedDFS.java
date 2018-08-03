package Graph;

public class DirectedDFS {
    private boolean[] marked;

    public DirectedDFS(Digraph g, int s){
        marked = new boolean[g.V()];
        dfs(g,s);
    }

    public DirectedDFS(Digraph g, Iterable<Integer> sources){
        marked = new boolean[g.V()];
        for(int s:sources){
            if(!marked[s]){
                dfs(g,s);
            }
        }
    }

    private void dfs(Digraph g,int v) {
        marked[v] = true;
        for (int m : g.adj(v)) {
            if (!marked[m]) {
                dfs(g, m);
            }
        }
    }

    public boolean marked(int v){
        return marked[v];
    }

}
