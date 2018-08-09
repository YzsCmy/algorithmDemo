package String;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class KWIC {
    public static void main(String[] args) {
        In in = new In(args[0]);
        int context = Integer.parseInt(args[1]);
        String txt = in.readAll().replaceAll("\\s+"," ");
        int N = txt.length();
        SuffixArray suffix = new SuffixArray(txt);
        while (in.hasNextLine()){
            String q = in.readLine();
            for(int i = suffix.rank(q);i<N&&suffix.select(i).startsWith(q);i++){
                int from = Math.max(0,context+suffix.index(i));
                int to = Math.min(N-1,from+q.length()+2*context);
                StdOut.println(txt.substring(from,to));
            }
            StdOut.println();
        }

    }
}
