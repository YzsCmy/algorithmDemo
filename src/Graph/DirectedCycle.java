package Graph;

import edu.princeton.cs.algs4.Stack;

public class DirectedCycle {

    private boolean[] marked;
    private int[] edgeTo;
    private boolean[] onStack;
    private Stack<Integer> cycle;

    public DirectedCycle(Digraph g){
        marked = new boolean[g.V()];
        edgeTo = new int[g.V()];
        onStack = new boolean[g.V()];
        for (int i = 0; i < g.V(); i++) {
            if(!marked[i]){
                dfs(g,i);
            }
        }
    }

    private void dfs(Digraph g,int v){
        onStack[v] = true;
        marked[v] = true;
        for(int m : g.adj(v)){
            if(hasCycle()){
                return;
            }else if(!marked[m]){
                edgeTo[m] = v;
                dfs(g,m);
            }else if(onStack[m]){
                cycle = new Stack<>();
                for(int x=v;x!=m;x=edgeTo[x]){
                    cycle.push(x);
                }
                cycle.push(m);
                cycle.push(v);
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
