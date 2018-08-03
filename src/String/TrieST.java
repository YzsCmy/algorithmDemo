package String;

import edu.princeton.cs.algs4.Queue;

public class TrieST <Value>{
    private static int R=256;
    private Node root;
    private static class Node{
        private Object value;
        private Node[] next = new Node[R];
    }

    public int size(){
        return size(root);
    }

    public int size(Node x){
        if(x==null){
            return 0;
        }
        int cnt = 0;
        if(x.value!=null){
            cnt++;
        }
        for (int i = 0; i < R; i++) {
            cnt+=size(x.next[i]);
        }
        return cnt;
    }

    public Value get(String s){
        Node c = get(root,s,0);
        if(c==null){
            return null;
        }
        return (Value) c.value;
    }

    private Node get(Node x,String s,int d){
        if(x==null){
            return null;
        }
        if(d==s.length()){
            return x;
        }
        return get(x.next[s.charAt(d)],s,d+1);
    }

    public void put(String s,Value v){
        root = put(root,s,v,0);
    }

    private Node put(Node x,String s,Value v,int d){
        if(x==null){
            x = new Node();
        }
        if(d==s.length()){
            x.value = v;
            return x;
        }
        char c = s.charAt(d);
        x.next[c] = put(x.next[c],s,v,d+1);
        return x;
    }

    public void delete(String s){
        root = delete(root,s,0);
    }

    private Node delete(Node x,String s,int d){
        if(x==null){
            return null;
        }
        if(d ==s.length()){
            x.value = null;
        }else {
            x.next[s.charAt(d)] = delete(x.next[s.charAt(d)],s,d+1);
        }

        if(x.value!=null){
            return x;
        }
        for (int i = 0; i < R; i++) {
            if(x.next[i]!=null){
                return x;
            }
        }
        return null;
    }

    private void collect(Node x, String pre, Queue<String> q){

        if(x==null){
            return;
        }
        if(x.value!=null){
            q.enqueue(pre);
        }
        for(char i = 0;i < R; i++){
            if(x.next[i]!=null){
                collect(x.next[i],pre+i,q);
            }
        }
    }

    private void collect(Node x,String pre,String pat,Queue<String> q){
        if(x==null){
            return;
        }
        int d = pre.length();
        if(pre.length()==d&&x.value!=null){
            q.enqueue(pre);
        }
        if(pre.length()==d){
            return;
        }
        char c = pat.charAt(d);
        for (char i = 0; i < R; i++) {
            if(c==i||c=='.'){
                collect(x.next[i],pre+i,pat,q);
            }
        }
    }

    public String longestPrefixOf(String s){
        int length = search(root,s,0,0);
        return s.substring(0,length);
    }

    private int search(Node x,String pre,int d,int length){
        if(x==null){
            return length;
        }
        if(x.value!=null){
            length = d;
        }
        if(d==length){
            return length;
        }
        char c = pre.charAt(d);
        return search(x.next[c],pre,d+1,length);
    }

    public Iterable<String> keysWithPreFix(String key){
        Queue<String> q = new Queue<>();
        collect(get(root,key,0),key,q);
        return q;
    }

    public Iterable<String> keysThatMatch(String pat){
        Queue<String> q = new Queue<>();
        collect(root,"",pat,q);
        return q;
    }

    public Iterable<String> keys(){
        return keysWithPreFix("");
    }

    public static void main(String[] args) {
        String[] stus = { "fsnsfsc","ogfel","akf","cadc","egdfdfdb","dvsdhna","wy","erfsdfdfsdfk"};
        TrieST<Integer> st = new TrieST<Integer>();
        for (int i = 0; i < stus.length; i++) {
            st.put(stus[i],i);
        }

        for(String s:st.keys()){
            System.out.println(s+"::"+st.get(s));
        }
    }
}
