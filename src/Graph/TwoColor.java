package Graph;

public class TwoColor {

    private boolean[] marked;
    private boolean[] color;
    private boolean isTwoColorable = true;

    public TwoColor(Graph g, int s){
        marked = new boolean[g.V()];
        color = new boolean[g.V()];
        dfs(g,s);
    }

    private void dfs(Graph g,int v){
        marked[v] = true;
        for(int m : g.adj(v)){
            if(!marked[m]){
                color[m]=!color[v];
                dfs(g,m);
            }else if(color[m]==color[v]){
                isTwoColorable =false;
            }
        }

    }

    private boolean isTwoColorable(){
        return isTwoColorable;
    }

}
