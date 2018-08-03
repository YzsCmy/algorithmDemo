package sort;

import java.util.Arrays;

public class ShellSort {
    public static void sort(Comparable[] a){
        int len = a.length;
        int h=1;
        while(h<len/3)
            h=h*3+1;
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
    }
    public static void main(String[] args) {

        Integer[] a = {2,41,1,23,7,21,12,81,12,4,17};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
