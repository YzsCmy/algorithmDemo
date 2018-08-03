package sort;

import java.util.Arrays;

public class HeapSort {
    public HeapSort(){}

    public void sort(Comparable[] a){
        int N = a.length;
        for (int i = N/2; i >= 1; i--) {
            sink(a, i, N);
        }
        while (N>1){
            exch(a, 1, N--);
            sink(a, 1, N);
        }

    }
    private void sink(Comparable[] a,int m, int N){
        while (2*m<=N){
            int f = 2*m;
            if(f<N&&less(a,f,f+1))
                f++;
            if(!less(a,m,f))
                break;
            exch(a,f,m);
            m=f;
        }
    }
    private void exch(Comparable[] a, int i, int j){
        Comparable t = a[i-1];
        a[i-1] = a[j-1];
        a[j-1] = t;
    }
    private boolean less(Comparable[] a,int i, int j){
        return a[i-1].compareTo(a[j-1])<0;
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        Integer[] a = {2,41,1,54,1,65,7,91,23,7,21,12,81,12,4,17,26};
        heapSort.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
