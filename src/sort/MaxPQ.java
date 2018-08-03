package sort;

import edu.princeton.cs.algs4.Heap;

import java.util.PriorityQueue;

public class MaxPQ <Key extends Comparable<Key>>{
    private Key[] pq;
    private int N = 0;
    public MaxPQ(int max){
        pq = (Key[]) new Comparable[max+1];
    }
    public boolean isEmpty(){
        return N==0;
    }
    public int size(){
        return N;
    }

    public void insert(Key k){
        pq[++N] = k;
        swim(N);
    }
    public Key delMax(){
        Key Max = pq[1];
        pq[1]=pq[N--];
        pq[N+1] = null;
        sink(1);
        return Max;
    }

    private void swim(int m){
        while(m>1&&less(m/2,m)){
            exch(m/2,m);
            m=m/2;
        }
    }

    private void sink(int m){
        while (m<=N){
            int f = 2*m;
            if(f<N&&less(f,f+1))
                f++;
            if(!less(m,f))
                break;
            exch(f,m);
            m=f;
        }
    }

    private boolean less(int i, int j){
        return pq[i].compareTo(pq[j])<0;
    }

    private void exch(int i, int j){
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    public static void main(String[] args) {
    }
}
