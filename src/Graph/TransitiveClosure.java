package Graph;

public class TransitiveClosure {
    private DirectedDFS[] all;
    public TransitiveClosure(Digraph g){
        all = new DirectedDFS[g.V()];
        for (int i = 0; i < g.V(); i++) {
            all[i] = new DirectedDFS(g,i);
        }
    }

    public boolean reachable(int v,int w){
        return all[v].marked(w);
    }
}
