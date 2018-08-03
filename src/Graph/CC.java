package Graph;

public class CC {
    private boolean[] marked;
    private int[] id;
    private int count;
    public CC(Graph g){
        marked = new boolean[g.V()];
        id = new int[g.V()];
        for (int s = 0; s<g.V(); s++){
            if(!marked[s]){
                dfs(g,s);
                count++;
            }
        }
    }

    private void dfs(Graph g,int s){
        marked[s] = true;
        id[s] = count;
        for(int w: g.adj(s)){
            if(!marked[w]){
                dfs(g,w);
            }
        }
    }

    public boolean connected(int v, int w){
        return id[v]==id[w];
    }

    public int id(int v){
        return id[v];
    }

    public int count(){
        return count;
    }
}
