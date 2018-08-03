package sort;

import java.util.Arrays;
import java.util.SortedMap;

public class SelectSort {
    public static void sort(Comparable[] a){
        int len = a.length;
        for (int i = 0; i < len; i++) {
            int min=i;
            for(int j = i + 1; j < len; j++){
                if(a[j].compareTo(a[min])<0) {
                    min = j;
                }
            }
            Comparable t = a[i];
            a[i]=a[min];
            a[min]=t;
        }
    }

    public static void main(String[] args) {
        Integer[] a = {2,41,1,23,7,21,12,81,12,4,17};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
