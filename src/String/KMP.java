package String;

public class KMP {
    private String pat;
    private int[][] dfa;

    public KMP(String pat) {
        int R = 256;
        int M = pat.length();
        dfa = new int[R][M];
        dfa[pat.charAt(0)][0] = 1;
        for (int x = 0, j = 1; j < R; j++) {
            for (char c = 0; c < R; c++) {
                dfa[c][j] = dfa[c][x];
            }
            dfa[pat.charAt(j)][j] = j+1;
            x = dfa[pat.charAt(j)][x];
        }
    }

    public int search(String txt){
        int N = txt.length(),M = pat.length();
        int i,j;
        for (i = 0,j=0; i < N &j<M; i++) {
            j = dfa[txt.charAt(i)][j];
        }
        if(j==M){
            return i-M;
        }else {
            return N;
        }
    }
}
