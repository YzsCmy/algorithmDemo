package String;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class LRS {

    public static void main(String[] args) {
        String txt = StdIn.readAll();
        int N = txt.length();
        SuffixArray suffixArray = new SuffixArray(txt);
        String lrs = "";
        for (int i = 1; i < N; i++) {
            int len = suffixArray.lcp(i);
            if(len>lrs.length()){
                lrs = suffixArray.select(i).substring(0,len);
            }
        }
        StdOut.println(lrs);
    }
}
