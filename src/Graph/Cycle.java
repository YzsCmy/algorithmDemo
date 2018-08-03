package Graph;

public class Cycle {
    private boolean[] marked;
    private boolean hasCycle;

    public Cycle(Graph g, int s){
        marked = new boolean[g.V()];
        dfs(g,s,s);
    }

    private void dfs(Graph g,int v,int u){
        marked[v] = true;
        for(int m : g.adj(v)){
            if(!marked[m]){
                dfs(g,m,v);
            }else if(m!=u){
                hasCycle = true;
            }
        }

    }

    public boolean hasCycle(){
        return hasCycle;
    }


}
