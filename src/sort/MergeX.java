package sort;

import java.util.Arrays;

public class MergeX {
    private static Comparable[] aux;
    public static void sort(Comparable[] a){
        aux = new Comparable[a.length];
        sort(a, 0, a.length-1);
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi){
        int i = lo,j=hi;
        for (int k = lo; k <= mid; k++) {
            aux[k] = a[k];
        }
        for (int k = mid+1; k <= hi; k++) {
            aux[k] = a[hi+mid+1-k];
        }
        for (int k = lo; k <= hi; k++){

            if( aux[i].compareTo(aux[j]) > 0 ){
                a[k] = aux[j--];
            }else{
                a[k] = aux[i++];
            }
        }

    }

    public static void sort(Comparable[] a, int lo, int hi){
        if(hi<=lo){
            return;
        }
        int mid = lo+(hi-lo)/2;
        sort(a,lo,mid);
        sort(a,mid+1,hi);
        merge(a,lo,mid,hi);
    }

    public static void main(String[] args) {
        Integer[] a = {2,41,1,23,7,21,12,81,12,4,17};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
