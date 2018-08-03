package SymbolTable;

import foundation.MyStack;

import java.nio.file.FileStore;

public class SequentialSearchST<Key,Value> {
    private Node first;
    private int N = 0;
    private class Node{
        Key key;
        Value val;
        Node next;
        public Node(Key key, Value val, Node next){
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public Value get(Key key){
        for(Node n = first; n!=null; n=n.next){
            if(key.equals(n.key)){
                return n.val;
            }
        }
        return  null;
    }

    public void put(Key key, Value val){
        for(Node n=first;n!=null;n=n.next){
            if(key.equals(n.key)){
                n.val = val;
                return;
            }
        }
        first = new Node(key,val,first);
        N++;
    }

    public int size(){
        return N;
    }
    public boolean isEmpty(){
        return size()==0;
    }

    public void delete(Key key){
        if(N<=0)
            return;
        if(N==1&&first.key.equals(key)){
            first = null;
            N--;
            return;
        }
        if(first.key.equals(key)){
            first=first.next;
            N--;
            return;
        }
        Node pre = first;
        Node index = first.next;
        while (!index.key.equals(key)){
            pre = index;
            index = index.next;
            if(index==null)
                return;
        }
        pre.next = index.next;
        index = null;
    }

    public Iterable<Key> keys(){
        MyStack<Key> stack = new MyStack<>();
        for(Node x=first; x!=null; x=x.next){
            stack.push(x.key);
        }
        return stack;
    }

    public static void main(String[] args) {

        SequentialSearchST<String,Integer> st = new SequentialSearchST<>();
        for (int i = 0; i < 1000; i++) {
            st.put("String-"+i,i);
        }
        for (String key:st.keys()) {
            System.out.println(key+"  "+st.get(key));
        }
        st.delete("String-999");
        st.delete("String-784");
        for (String key:st.keys()) {
            System.out.println(key+"  "+st.get(key));
        }

    }
}
