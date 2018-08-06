package String;

import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

public class RLE {
    public static void expend(){

        boolean b = false;
        while (!BinaryStdIn.isEmpty()){

            char c = BinaryStdIn.readChar();
            for (int i = 0; i < c; i++) {
                BinaryStdOut.write(b);
            }
            b = !b;
        }
    }

    public static void compress(){
        char cnt = 0;
        boolean b ,old = false;
        while (!BinaryStdIn.isEmpty()){
            b = BinaryStdIn.readBoolean();
            if(b!=old){
                BinaryStdOut.write(cnt);
                cnt = 0;
                b=!b;
            }else{
                if(cnt == 255){
                    BinaryStdOut.write(cnt);
                    cnt = 0;
                    BinaryStdOut.write(cnt);
                }
            }
            cnt++;
        }
        BinaryStdOut.write(cnt);
        BinaryStdOut.close();
    }

}
