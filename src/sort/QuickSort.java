package sort;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class QuickSort {
    public static void sort(Comparable[] a){
        StdRandom.shuffle(a);
        sort(a,0,a.length-1);
    }
    public static void sort(Comparable[] a, int lo, int hi){
        if(hi<=lo){
            return;
        }
        int j = partition(a,lo,hi);
        sort(a,lo,j-1);
        sort(a,j+1,hi);

    }
    public static int partition(Comparable[] a,int lo, int hi){
        int i = lo, j = hi+1;
        Comparable v = a[lo];
        while (true){

            while(v.compareTo(a[++i])>0){
                if(i==hi)
                    break;
            }
            while(v.compareTo(a[--j])<0){
                if(j==lo)
                    break;
            }
            if(i>=j)
                break;
            Comparable t = a[i];
            a[i] = a[j];
            a[j] = t;
        }
        Comparable t = a[lo];
        a[lo] = a[j];
        a[j] = t;
        return j;
    }

    public static void main(String[] args) {
        Integer[] a = {2,41,1,54,1,65,7,91,23,7,21,12,81,2,41,1,54,1,65,12,4,17,26};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
