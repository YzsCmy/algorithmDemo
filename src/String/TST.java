package String;

public class TST <Value>{
    private Node root;
    private class Node{
        Value v;
        char c;
        Node left,mid,right;
    }

    public Value get(String s){
        Node n = get(root,s,0);
        if(n!=null){
            return n.v;
        }else {
            return null;
        }
    }

    private Node get(Node x,String s,int d){
        if(x==null){
            return null;
        }
        char c = s.charAt(d);
        if(x.c<c){
            return get(x.right,s,d);
        }else if(x.c>c){
            return get(x.left,s,d);
        }else if(d<s.length()-1){
            return get(x.mid,s,d+1);
        }else{
            return x;
        }
    }

    public void put(String s,Value v){
        root = put(root,s,v,0);
    }

    private Node put(Node x,String s,Value v,int d){
        char c = s.charAt(d);
        if(x==null){
            x = new Node();
            x.c = c;
        }
        if(x.c>c){
            x.left = put(x.left,s,v,d+1);
        }else if(x.c<c){
            x.right = put(x.right,s,v,d+1);
        }else if(d<s.length()-1){
            x.mid = put(x.mid,s,v,d+1);
        }else {
            x.v = v;
        }
        return x;
    }

}
