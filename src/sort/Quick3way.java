package sort;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class Quick3way {

    public static void sort(Comparable[] a){
        StdRandom.shuffle(a);
        sort(a,0,a.length-1);
    }
    public static void sort(Comparable[] a, int lo, int hi){
        if(hi<=lo){
            return;
        }
        Comparable v = a[lo];
        int i = lo+1, lt = lo, gt = hi;
        while (i<=gt){
            int cmp = a[i].compareTo(v);
            if(cmp<0)
                exch(a,lt++,i++);
            else if(cmp>0)
                exch(a,i,gt--);
            else
                i++;
        }
        sort(a,lo,lt-1);
        sort(a,gt+1,hi);
    }

    public static void exch(Comparable[] a,int i,int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    public static void main(String[] args) {
        Integer[] a = {2,41,1,54,1,65,7,91,23,7,21,12,81,2,41,1,54,1,65,12,4,17,26};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
