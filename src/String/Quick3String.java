package String;

public class Quick3String {

    private static int charAt(String s,int d){
        return d<s.length()?s.charAt(d):-1;
    }

    private static void sort(String[] a){
        sort(a,0,a.length-1,0);
    }
    private static void sort(String[] a,int lo,int hi,int d){
        if(lo>=hi){
            return;
        }
        int lt = lo,i = lo+1, gt = hi;
        String s = a[lo];
        while (i<=gt){
            int cmp = charAt(s,d)-charAt(a[i],d);
            if(cmp>0){
                exch(a,lt++,i++);
            }else if(cmp<0){
                exch(a,i,gt--);
            }else{
                i++;
            }
        }
        sort(a,lo,lt-1,d);
        if(d<a.length){
            sort(a,lt,gt,d+1);
        }
        sort(a,gt+1,hi,d);
    }

    private static void exch(String[] s,int a,int b){
        String t = s[a];
        s[a] = s[b];
        s[b] = t;
    }

    public static void main(String[] args) {
        String[] stus = {"fsnsfsc", "ogfel", "akf", "cadc", "cadc", "egdfdfdb", "ogfel", "akf", "cadc", "egdfdfdb", "dvsdhna", "wy", "erfsdfdfsdfk"};
        long start = System.currentTimeMillis();
        MSD.sort(stus);
        System.currentTimeMillis();
        long end = System.currentTimeMillis();
        for (String s : stus) {
            System.out.println(s);
        }
        System.out.println(end + "::" + start);

    }
}
