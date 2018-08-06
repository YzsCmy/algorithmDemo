package String;

import Graph.Digraph;
import Graph.DirectedDFS;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Stack;

public class NFA {
    private char[] re;
    private int M;
    private Digraph g;

    public NFA(String regexp){
        Stack<Integer> ops = new Stack<>();
        re = regexp.toCharArray();
        M = regexp.length();
        g = new Digraph(M+1);
        for (int i = 0; i < M; i++) {

            int lp = i;
            if(re[i]=='('||re[i]=='|'){
                ops.push(i);
            }else if(re[i]==')'){
                int or = ops.pop();
                if(re[or]=='|'){
                    lp = ops.pop();
                    g.addEdge(lp,or+1);
                    g.addEdge(or,i);
                }
            }
            if(i<M-1&&re[i+1]=='*'){
                g.addEdge(i+1,lp);
                g.addEdge(lp,i+1);
            }

            if(re[i]=='('||re[i]=='*'||re[i]==')'){
                g.addEdge(i,i+1);
            }
        }
    }

    public boolean recognizes(String txt){
        Bag<Integer> pc = new Bag<>();
        DirectedDFS dfs = new DirectedDFS(g, 0);
        for (int v = 0; v < g.V(); v++) {
            if (dfs.marked(v)) {
                pc.add(v);
            }
        }

        for (int i = 0; i < txt.length(); i++) {
            Bag<Integer> match = new Bag<>();
            for (int v : pc) {
                if (v < M) {
                    if (re[v] == txt.charAt(i) || re[v] == '.') {
                        match.add(v + 1);
                    }
                }
            }
            pc = new Bag<>();
            dfs = new DirectedDFS(g, match);
            for (int v = 0; v < g.V(); v++) {
                if (dfs.marked(v)) {
                    pc.add(v);
                }
            }
        }

        for (int v : pc) {
            if (v == M) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String regexp = "(.*" +"(A*B|AC)D"+ ".*)";
        NFA nfa = new NFA(regexp);
        String[] txt = {"AC","AD","AAABCD","ABD","ADD","BCD","ABCCBD","BABAAA","BABBAAA"};
        for(String s:txt){
            if (nfa.recognizes(s)) {
                System.out.println(s);
            }
        }
    }
}
