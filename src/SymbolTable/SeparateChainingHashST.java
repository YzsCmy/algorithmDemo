package SymbolTable;

import foundation.MyStack;

public class SeparateChainingHashST <Key,Value>{
    private final static int INICAP = 4;
    private int n;
    private int m;
    private SequentialSearchST<Key,Value>[] st;

    public SeparateChainingHashST(){
        this(INICAP);
    }
    public SeparateChainingHashST(int cap){
        this.m=cap;
        st=(SequentialSearchST<Key,Value>[])new SequentialSearchST[cap];
        for (int i = 0; i < cap; i++) {
            st[i] = new SequentialSearchST<>();
        }
    }

    private void resize(int cap){
        SeparateChainingHashST<Key,Value> t = new SeparateChainingHashST(cap);
        for (int i = 0; i < m; i++) {
            for(Key s:st[i].keys()){
                t.put(s,st[i].get(s));
            }
        }
        this.n = t.n;
        this.m = t.m;
        this.st = t.st;
    }

    public int size(){
        return n;
    }

    public boolean isEmpty(){
        return size()==0;
    }

    public boolean contains(Key k){
        return get(k)!=null;
    }

    private int hash(Key k){
        return (k.hashCode()&0x7fffffff)%m;
    }

    public Value get(Key k){
        return st[hash(k)].get(k);
    }

    public void put(Key k,Value v){
        if(!contains(k)){
            n++;
        }
        if(n>=10*m){
            resize(m*2);
        }
        st[hash(k)].put(k,v);
    }

    public void delete(Key k){
        if(contains(k)){
            n--;
        }
        st[hash(k)].delete(k);

        if(m>INICAP&&n<=2*m){
            resize(m/2);
        }
    }

    public Iterable keys(){
        MyStack<Key> stack = new MyStack<>();
        for (int i = 0; i < m; i++) {
            for (Key s: st[i].keys()) {
                stack.push(s);
            }
        }
        return stack;
    }

    public static void main(String[] args) {

    }
}
