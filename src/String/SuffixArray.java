package String;

import sort.Quick3way;

public class SuffixArray {

    private final String[] suffixes;
    private final int N;
    public SuffixArray(String txt){
        N = txt.length();
        suffixes = new String[N];
        for (int i = 0; i < N; i++) {
            suffixes[i] = txt.substring(i);
        }
        Quick3way.sort(suffixes);
    }

    public int length(){
        return N;
    }

    public String select(int i){
        return suffixes[i];
    }

    public int index(int i){
        return N-suffixes[i].length();
    }

    private int lcp(String a,String b){
        int length = Math.min(a.length(),b.length());
        for (int i = 0; i < length; i++) {
            if(a.charAt(i)!=b.charAt(i)){
                return i;
            }
        }
        return N;
    }

    public int lcp(int i){
        return lcp(suffixes[i],suffixes[i-1]);
    }

    public int rank(String s){
        int lo = 0,hi = N-1;
        while (lo<=hi){
            int mid = lo+(hi-lo)/2;
            int cmp = s.compareTo(suffixes[mid]);
            if(cmp>0){
                lo = mid+1;
            }else if(cmp<0){
                hi = mid-1;
            }else {
                return mid;
            }
        }
        return lo;
    }
}
