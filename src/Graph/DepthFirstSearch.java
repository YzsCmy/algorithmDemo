package Graph;

public class DepthFirstSearch {
    private boolean[] marked;
    private int count;

    public DepthFirstSearch(Graph g, int s){
        marked = new boolean[g.V()];
        dfs(g,s);
    }

    private void dfs(Graph g,int v){
        marked[v] = true;
        count++;
        for(int m : g.adj(v)){
            if(!marked[m]){
                dfs(g,m);
            }
        }

    }

    public int count(){
        return count;
    }

}
