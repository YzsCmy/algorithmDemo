package SymbolTable;

import foundation.MyStack;

public class BST <Key extends Comparable<Key>, Value>{
    private Node root;
    private class Node{
        private Node left;
        private Node right;
        private Key key;
        private Value val;
        private int n;

        public Node(Key k,Value v,int s){
            this.val=v;
            this.key=k;
            this.n=s;
        }
    }

    public int size(){
        return size(root);
    }

    private int size(Node k){
        if(k==null){
            return 0;
        }else{
            return k.n;
        }

    }

    public Key min(){
        return min(root);
    }

    private Key min(Node n){
        if(n.left==null){
            return n.key;
        }
        return min(n.left);
    }
    public Key max(){
        return max(root);
    }

    private Key max(Node n){
        if(n.right==null){
            return n.key;
        }
        return max(n.right);
    }

    public Value get(Key k){
        return get(root,k);
    }

    private Value get(Node t, Key k){
        if(t==null){
            return null;
        }
        int cmp = k.compareTo(t.key);
        if(cmp<0){
            return get(t.left,k);
        }else if(cmp>0){
            return get(t.right,k);
        }else{
            return t.val;
        }
    }

    public void put(Key k,Value v){
        root = put(root,k,v);
    }

    private Node put(Node f, Key k, Value v){
        if(f==null){
            return new Node(k,v,1);
        }
        int cmp = k.compareTo(f.key);
        if(cmp<0){
            f.left = put(f.left,k,v);
        }else if(cmp>0){
            f.right = put(f.right,k,v);
        }else{
            f.val = v;
        }
        f.n=size(f.left)+size(f.right)+1;
        return f;
    }

    public Key select(int k){
        return select(root,k).key;
    }

    private Node select(Node n, int k){
        if(n==null){
            return null;
        }
        int s = size(n.left);
        if(k<s){
            return select(n.left,k);
        }else if(k>s){
            return select(n.right,k-s-1);
        }else{
            return n;
        }
    }

    public int rank(Key key){
        return rank(root, key);
    }

    private int rank(Node n, Key k){
        if(n==null){
            return 0;
        }
        int cmp = k.compareTo(n.key);
        if(cmp<0){
            return rank(n.left,k);
        }else if(cmp>0){
            return 1+size(n.left)+rank(n.right,k);
        }else{
            return size(n.left);
        }
    }

    public void deleteMin(){
        root = deleteMin(root);
    }

    private Node deleteMin(Node n){

        if(n.left==null){
            return n.right;
        }
        n.left = deleteMin(n.left);
        n.n = size(n.left)+size(n.right)+1;
        return n;
    }

    public void deleteMax(){
        root = deleteMax(root);
    }

    private Node deleteMax(Node n){

        if(n.right==null){
            return n.left;
        }
        n.right = deleteMin(n.right);
        n.n = size(n.left)+size(n.right)+1;
        return n;
    }

    public void delete(Key k){
        root = delete(root,k);
    }

    private Node delete(Node n, Key k){

        if(n==null){
            return null;
        }
        int cmp = k.compareTo(n.key);

        if(cmp<0){
            n.left = delete(n.left,k);
        }else if(cmp>0){
            n.right = delete(n.right,k);
        }else{
            if(n.left==null){
                return n.right;
            }
            if(n.right==null){
                return n.left;
            }
            Node t = deleteMin(n.right);
            n.right = t;
        }
        n.n = size(n.left)+size(n.right)+1;
        return n;

    }

    public Iterable<Key> keys(){
        return keys(min(),max());
    }

    public Iterable<Key> keys(Key lo,Key hi){
        MyStack<Key> stack = new MyStack<>();
        keys(root,stack,lo,hi);
        return stack;
    }

    private void keys(Node n, MyStack s, Key lo, Key hi){
        if(n==null){
            return;
        }
        int cmplo = lo.compareTo(n.key);
        int cmphi = hi.compareTo(n.key);
        if(cmplo<0){
            keys(n.left,s,lo,hi);
        }
        if(cmplo<=0&&cmphi>=0){
            s.push(n.key);
        }
        if(cmphi>0){
            keys(n.right,s,lo,hi);
        }
    }

    public static void main(String[] args) {
        BST<String,Integer> st = new BST<>();
        for (int i = 0; i < 100; i++) {
            st.put("String-"+i,i);
        }
        for (String key:st.keys()) {
            System.out.println(key+"  "+st.get(key));
        }
        st.delete("String-99");
        st.delete("String-78");
        for (String key:st.keys()) {
            System.out.println(key+"  "+st.get(key));
        }
    }
}
