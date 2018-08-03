package String;

public class MSD {
    private static int R = 256;
    private static String[] aux;
    private static int m = 5;
    public static void sort(String[] a){
        int N = a.length;
        aux = new String[N];
        sort(a,0,N-1,0);
    }

    private static int charAt(String s,int d){

        return d<s.length()?s.charAt(d):-1;
    }

    private static void sort(String[] a,int lo, int hi,int d){
        if(hi<=lo+m){
            subSort(a,lo,hi,d);
            return;
        }
        int[] count = new int[R+2];

        for (int i = lo; i <=hi; i++) {
            count[charAt(a[i],d)+2]++;
        }

        for (int i = 0; i < R+1; i++) {
            count[i+1] += count[i];
        }

        for (int i = lo; i <= hi; i++) {
            aux[count[charAt(a[i],d)+1]++] = a[i];
        }

        for (int i = lo; i <= hi; i++) {
            a[i] = aux[i-lo];
        }

        for (int i = 0; i < R; i++) {
            sort(a,lo+count[i],lo+count[i+1]-1,d+1);
        }
    }

    private static void subSort(String[] a,int lo,int hi,int d){
        for (int i = lo; i < hi ; i++) {
            for (int j = i; j > lo &&less(a[j],a[j-1],d); j--) {
                exch(a,j-1,j);
            }
        }
    }

    private static boolean less(String a,String b,int d){
        return a.substring(d).compareTo(b.substring(d))<0;
    }

    private static void exch(String[] s,int a, int b){
        String t = s[a];
        s[a] = s[b];
        s[b] = t;
    }

    public static void main(String[] args) {
        String[] stus = { "fsnsfsc","ogfel","akf","cadc","cadc","egdfdfdb","ogfel","akf","cadc","egdfdfdb","dvsdhna","wy","erfsdfdfsdfk"};
        long start = System.currentTimeMillis();
        MSD.sort(stus);
        long end = System.currentTimeMillis();
        for(String s:stus){
            System.out.println(s);
        }
        System.out.println(end+"::"+start);
    }
}
