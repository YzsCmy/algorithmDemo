package SymbolTable;

import foundation.MyStack;

public class BinarySearchST <Key extends Comparable<Key>,Value>{
    private Key[] key;
    private Value[] val;
    private int N;
    BinarySearchST(int capacity){
        key = (Key[]) new Comparable[capacity];
        val = (Value[]) new Object[capacity];
        N = 0;
    }
    public int size(){
        return N;
    }

    public boolean isEmpty(){
        return N==0;
    }

    public Value get(Key k){
        if (key == null) throw new IllegalArgumentException("argument to put() is null");
        if(isEmpty()){
            return null;
        }
        int i = rank(k);
        if(i<N&&k.compareTo(key[i])==0){
            return val[i];
        }else{
            return null;
        }
    }

    public void put(Key k, Value v){
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");

        if (val == null) {
            delete(k);
            return;
        }
        int i = rank(k);
        if(i<N&&k.compareTo(key[i])==0){
            val[i]=v;
            return;
        }

        if(N==key.length){
            resize(2*key.length);
        }
        for (int j = N; j >i ; j--) {
            key[j]=key[j-1];
            val[j]=val[j-1];
        }
        key[i]=k;
        val[i]=v;
        N++;
    }

    public int rank(Key k){
        int lo = 0, hi = N-1;
        while (lo<=hi){
            int mid = lo+(hi-lo)/2;
            int cmp = k.compareTo(key[mid]);
            if(cmp<0){
                hi = mid-1;
            }else if(cmp>0){
                lo = mid+1;
            }else{
                return mid;
            }
        }
        return lo;
    }

    public void delete(Key k){
        if (key == null) throw new IllegalArgumentException("argument to put() is null");

        if(isEmpty()){
            return;
        }
        int i = rank(k);
        if(i==N||k.compareTo(key[i])!=0){
            return;
        }
        for (int j = i; j < N-1; j++) {
            key[j]=key[j+1];
            val[j]=val[j+1];
        }
        N--;
        if(N>0&&N==key.length/4){
            resize(key.length/2);
        }
        key[N]=null;
        val[N]=null;

    }

    public void resize(int size){
        Key[] temkey = (Key[]) new Comparable[size];
        Value[] temval = (Value[]) new Object[size];
        for (int i = 0; i < N; i++) {
            temkey[i]=key[i];
            temval[i]=val[i];
        }
        key=temkey;
        val=temval;
    }

    public Iterable<Key> keys(){
        MyStack<Key> stack = new MyStack<>();
        for (int i = 0; i < N; i++) {
            stack.push(key[i]);
        }
        return stack;
    }

    public static void main(String[] args) {
        BinarySearchST<String,Integer> st = new BinarySearchST<>(10);
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
