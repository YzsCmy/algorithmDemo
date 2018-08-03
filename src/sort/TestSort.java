package sort;

import java.util.Arrays;

public class TestSort {

    private static <Item extends Comparable> void sort(Item[] t){
        sort(t,0,t.length-1);
    }

    private static <Item extends Comparable> void sort(Item[] t,int lo, int hi){
        if(lo>=hi){
            return;
        }
        int lt = lo, i = lo+1, gt = hi;
        Item s =t[lo];
        while (i<=gt){
            int v = t[i].compareTo(s);
            if (v<0){
                exch(t,lt++,i++);
            }
            else if(v>0){
                exch(t,i,gt--);
            }
            else{
                i++;
            }
        }
        sort(t,lo,lt-1);
        sort(t,gt+1,hi);
    }

    private static <Item extends Comparable> void exch(Item[] t,int a,int b){
        Item v = t[a];
        t[a] = t[b];
        t[b] = v;
    }

    public static void main(String[] args) {
        Integer[] a = {2,41,1,54,1,65,7,91,23,7,21,12,81,2,41,1,54,1,65,12,4,17,26};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
