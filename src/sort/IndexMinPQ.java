package sort;

import java.util.NoSuchElementException;

public class IndexMinPQ<Key extends Comparable<Key>>{
    private Key[] keys;
    private int[] pq;
    private int[] qp;
    private int N = 0;
    public IndexMinPQ(int max){

        keys = (Key[]) new Comparable[max+1];
        pq = new int[max+1];
        qp = new int[max+1];
        for (int i = 0; i < max+1; i++) {
            qp[i] = -1;
        }
    }
    public boolean isEmpty(){
        return N==0;
    }
    public int size(){
        return N;
    }


    public boolean contains(int k){
        return qp[k]!=-1;
    }

    public int minIndex(){
        return pq[1];
    }
    public void insert(int i,Key k){
        N++;
        pq[N] = i;
        qp[i] = N;
        keys[i] = k;
        swim(N);
    }

    public void change(int i,Key key){
        if (i < 0 || i >= N+1) throw new IndexOutOfBoundsException();
        if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
        keys[i] = key;
        int index = qp[i];
        sink(index);
        swim(index);

    }
    public int delMin(){
        int indexMin = pq[1];
        exch(1,N--);
        sink(1);
        keys[pq[N+1]] = null;
        qp[pq[N+1]] = -1;
        return indexMin;
    }

    public Key min(){
        return keys[pq[1]];
    }

    public void delete(int k){
        if(!contains(k)){
            return;
        }
        exch(qp[k],N--);
        swim(qp[k]);
        sink(qp[k]);
        keys[k] = null;
        qp[pq[k]] = -1;
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
        return keys[pq[i]].compareTo(keys[pq[j]])<0;
    }

    private void exch(int i, int j){
        int t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
        qp[pq[i]]= i;
        qp[pq[j]]= j;
    }

    public static void main(String[] args) {
    }
}
