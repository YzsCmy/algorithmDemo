package sort;

import java.util.Arrays;
import java.util.Currency;

public class InsertSort {
   /* public static void sort(Comparable[] a){
        int len = a.length;
        int j;
        for (int i = 1; i < len; i++) {
            Comparable t = a[i];
            for (j = i; j > 0 && t.compareTo(a[j-1])<0; j--) {
                a[j]=a[j-1];
            }
            a[j]=t;
        }
         try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }*/
   /* public static void sort(Comparable[] a){
        int len = a.length;
        int h=1;
        while(h<len/3){
            h=h*3+1;
        }
        while (h>=1){
            for (int i = h; i < len; i++) {
                for (int j = i; j >= h && a[j].compareTo(a[j-h])<0; j-=h) {
                    Comparable t = a[j-h];
                    a[j-h] = a[j];
                    a[j] = t;
                }
            }
            h=h/3;
        }
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }*/
    public static void sort(Comparable[] a){
        int len = a.length;
        for (int i = 1; i < len; i++) {
            for (int j = i; j > 0 && a[j].compareTo(a[j-1])<0; j--) {
                Comparable t = a[j];
                a[j] = a[j-1];
                a[j-1] = t;
            }
        }
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Integer[] a = {2,41,1,23,7,21,12,81,12,4,17};
        long start = System.currentTimeMillis();
        sort(a);
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
