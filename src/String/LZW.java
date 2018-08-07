package String;

import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;
import edu.princeton.cs.algs4.TST;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class LZW {
    private static final int R = 256;
    private static final int L = 4096;
    private static final int W = 12;

    public static void compress(){
        String input = BinaryStdIn.readString();
        TST<Integer> st = new TST<>();
        for (int i = 0; i < R; i++) {
            st.put(""+(char)i,i);
        }
        int code = R+1;
        while (input.length()>0){
            String s = st.longestPrefixOf(input);
            BinaryStdOut.write(st.get(s),W);
            int t = s.length();
            if(t<input.length()&&code<L){
                st.put(input.substring(0,t+1),code++);
            }
            input = input.substring(t);
        }

        BinaryStdOut.write(R,W);
        BinaryStdOut.close();
    }

    public static void expand(){
        String[] st = new String[L];
        int i;
        for (i = 0; i < R; i++) {
            st[i] = ""+(char)i;
        }
        st[i++] = " ";
        int codeword = BinaryStdIn.readInt(W);
        String val = st[codeword];
        while (true){
            BinaryStdOut.write(val);
            codeword = BinaryStdIn.readInt(W);
            if(codeword==R){
                break;
            }
            String s = st[codeword];
            if(i == codeword){
                s = val+val.charAt(0);
            }
            if(i<L){
                st[i++] = val+s.charAt(0);
            }
            val = s;
        }
        BinaryStdOut.close();
    }

    public static void main(String[] args) {

        if("-".equals(args[0])){
            try {
                BufferedInputStream in = new BufferedInputStream(new FileInputStream("C:\\Users\\yzs\\Desktop\\aa.doc"));
                System.setIn(in);
                PrintStream printStream = new PrintStream(new FileOutputStream("C:\\Users\\yzs\\Desktop\\b"));
                System.setOut(printStream);
            }catch (Exception e){
            }
            compress();
        }else if("+".equals(args[0])){
            try {
                BufferedInputStream in = new BufferedInputStream(new FileInputStream("C:\\Users\\yzs\\Desktop\\b"));
                System.setIn(in);
                PrintStream printStream = new PrintStream(new FileOutputStream("C:\\Users\\yzs\\Desktop\\bb.doc"));
                System.setOut(printStream);
            }catch (Exception e){
            }
            expand();
        }

    }
}
