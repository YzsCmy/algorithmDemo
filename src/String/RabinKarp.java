package String;

import java.math.BigInteger;
import java.util.Random;


public class RabinKarp {
    private long hashpat;
    private int M;
    private int R=256;
    private long Q;
    private long RM;

    public RabinKarp(String pat){
        this.M = pat.length();
        this.Q = longRandomPrime();
        this.hashpat = hash(pat,M);
        RM = 1;
        for (int i = 1; i <=M-1 ; i++) {
            RM = (R *RM)%Q;
        }

    }

    public int search(String txt){
        int N  = txt.length();
        long txthash = hash(txt,M);
        if(txthash==hashpat){
            return 0;
        }
        for (int i = M; i < N; i++) {
            txthash = (txthash+Q-RM*txt.charAt(i-M)%Q)%Q;
            txthash = (txthash*R + txt.charAt(i))%Q;
            if(txthash==hashpat){
                return i-M+1;
            }
        }
        return N;
    }

    private static long longRandomPrime() {
        BigInteger prime = BigInteger.probablePrime(31, new Random());
        return prime.longValue();
    }

    private long hash(String key,int s){
        long h = 0;
        for (int i = 0; i < s; i++) {
            h = (h*R + key.charAt(i))%Q;
        }
        return h;
    }

}
