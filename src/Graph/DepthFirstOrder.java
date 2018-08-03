package Graph;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class DepthFirstOrder {

    private boolean[] marked;
    private Queue<Integer> pre;
    private Queue<Integer> post;
    private Stack<Integer> reversePost;

    public DepthFirstOrder(Digraph g){
        marked = new boolean[g.V()];
        pre = new Queue<>();
        post = new Queue<>();
        reversePost = new Stack<>();
        for (int i = 0; i < g.V(); i++) {
            if(!marked[i]){
                dfs(g,i);
            }
        }
    }
    public DepthFirstOrder(EdgeWeightDigraph g){
        marked = new boolean[g.V()];
        pre = new Queue<>();
        post = new Queue<>();
        reversePost = new Stack<>();
        for (int i = 0; i < g.V(); i++) {
            if(!marked[i]){
                dfs(g,i);
            }
        }
    }

    private void dfs(Digraph g,int v){
        pre.enqueue(v);
        marked[v] = true;
        for(int m : g.adj(v)){
            if(!marked[m]){
                dfs(g,m);
            }
        }
        post.enqueue(v);
        reversePost.push(v);

    }

    private void dfs(EdgeWeightDigraph g,int v){
        pre.enqueue(v);
        marked[v] = true;
        for(DirectedEdge e : g.adj(v)){
            int m = e.to();
            if(!marked[m]){
                dfs(g,m);
            }
        }
        post.enqueue(v);
        reversePost.push(v);

    }

    public Iterable<Integer> pre(){
        return pre;
    }
    public Iterable<Integer> post(){
        return post;
    }
    public Iterable<Integer> reversePost(){
        return reversePost;
    }
}
