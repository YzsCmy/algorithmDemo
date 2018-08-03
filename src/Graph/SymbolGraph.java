package Graph;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;

public class SymbolGraph {
    private ST<String,Integer> st;
    private String[] keys;
    private Graph g;

    public SymbolGraph(String stream,String sp){
        st = new ST<>();
        In in = new In(stream);
        while (in.hasNextLine()){
            String[] a = in.readLine().split(sp);
            for (int i = 0; i < a.length; i++) {
                st.put(a[i],st.size());
            }
        }
        keys = new String[st.size()];
        for(String s:st.keys()){
            keys[st.get(s)] = s;
        }

        g = new Graph(st.size());
        in = new In(stream);
        while (in.hasNextLine()){
            String[] a = in.readLine().split(sp);
            int v =st.get(a[0]);
            for (int i = 1; i < a.length; i++) {
                g.addEdge(v,st.get(a[i]));
            }
        }
    }

    public boolean contains(String k){
        return st.contains(k);
    }

    public int index(String name){
        return st.get(name);
    }

    public String name(int k){
        return keys[k];
    }

    public Graph graph(){
        return this.g;
    }

}
