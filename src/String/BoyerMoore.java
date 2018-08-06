package String;

public class BoyerMoore {
    private int[] right;
    private String pat;
    public BoyerMoore(String pat){
        this.pat = pat;
        int R = 256;
        int M = pat.length();
        right = new int[R];
        for (int i = 0; i < R; i++) {
            right[i] = -1;
        }

        for (int i = 0; i < M; i++) {
            right[pat.charAt(i)] = i;
        }
    }

    public int search(String txt){
        int N = txt.length();
        int M = pat.length();
        for (int i = 0; i <= N-M; i++) {

            int skip = 0;
            for (int j = M-1; j >= 0; j--) {
                if(txt.charAt(i+j)!=pat.charAt(j)){
                    skip = j-right[txt.charAt(i+j)];
                    if(skip<1){
                        skip = 1;
                    }
                    break;
                }
            }
            if(skip==0){
                return i;
            }
        }
        return N;
    }
}
