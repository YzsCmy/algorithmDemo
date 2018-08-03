package Graph;

import edu.princeton.cs.algs4.Stack;

public class EdgeWeightDirectedcycle {

    private boolean[] marked;
    private DirectedEdge[] edgeTo;
    private boolean[] onStack;
    private Stack<DirectedEdge> cycle;

    public EdgeWeightDirectedcycle(EdgeWeightDigraph g){
        marked = new boolean[g.V()];
        edgeTo = new DirectedEdge[g.V()];
        onStack = new boolean[g.V()];
        for (int i = 0; i < g.V(); i++) {
            if(!marked[i]){
                dfs(g,i);
            }
        }
    }

    private void dfs(EdgeWeightDigraph g,int v){
        onStack[v] = true;
        marked[v] = true;
        for(DirectedEdge  e : g.adj(v)){
            int m = e.to();
            if(hasCycle()){
                return;
            }else if(!marked[m]){
                edgeTo[m] = e;
                dfs(g,m);
            }else if(onStack[m]){
                cycle = new Stack<>();
                for(DirectedEdge x=edgeTo[e.from()];x.from()!=m;x=edgeTo[x.from()]){
                    cycle.push(x);
                }
                cycle.push(e);
                return;
            }
        }

        onStack[v] = false;

    }

    public boolean hasCycle(){
        return cycle!=null;
    }

    public Iterable cycle(){
        return cycle;
    }
}
