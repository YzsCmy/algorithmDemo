package String;

public class Brute {
    public int search(String txt,String pat){
        int t = txt.length();
        int p = pat.length();
        int i,j;
        for (i = 0,j=0; i <= t-p&&j<p; i++) {
            if(txt.charAt(i)==pat.charAt(j)){
                j++;
            }else {
                i=i-j;
                j=0;
            }
        }
        if(j==p){
            return i-j;
        }else {
            return t;
        }
    }
}
