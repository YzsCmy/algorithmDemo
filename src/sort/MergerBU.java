package sort;

import java.util.Arrays;

public class MergerBU {
    private static Comparable[] aux;
    public static void sort(Comparable[] a){
        int n = a.length;
        aux = new Comparable[n];
        for (int i = 1; i < n; i=i+i) {
            for (int j = 0; j < n-i; j+=i+i) {
                merge(a,j,j+i-1,Math.min(j+i+i-1,n-1));
            }
        }
    }
    public static void merge(Comparable[] a, int lo, int mid, int hi){
        int i = lo,j=mid+1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        for (int k = lo; k <= hi; k++){
            if(i>mid){
                a[k] = aux[j++];
            }else if(j>hi){
                a[k] = aux[i++];
            }else if( aux[i].compareTo(aux[j]) > 0 ){
                a[k] = aux[j++];
            }else{
                a[k] = aux[i++];
            }
        }

    }

    public static void main(String[] args) {
//        Integer[] a = {2,41,1,23,7,21,12,81,12,4,17};
        Integer[] a = {2,41,1,54,1,65,7,91,23,7,21,12,81,12,4,17,26};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
