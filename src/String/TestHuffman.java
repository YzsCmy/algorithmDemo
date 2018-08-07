package String;

import edu.princeton.cs.algs4.Huffman;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class TestHuffman {

    public static void main(String[] args) {
        if("-".equals(args[0])){
            try {
                BufferedInputStream in = new BufferedInputStream(new FileInputStream("C:\\Users\\yzs\\Desktop\\a.doc"));
                System.setIn(in);
                PrintStream printStream = new PrintStream(new FileOutputStream("C:\\Users\\yzs\\Desktop\\b"));
                System.setOut(printStream);
            }catch (Exception e){
            }
            Huffman.compress();
        }else if("+".equals(args[0])){
            try {
                BufferedInputStream in = new BufferedInputStream(new FileInputStream("C:\\Users\\yzs\\Desktop\\b"));
                System.setIn(in);
                PrintStream printStream = new PrintStream(new FileOutputStream("C:\\Users\\yzs\\Desktop\\b.doc"));
                System.setOut(printStream);
            }catch (Exception e){
            }
            Huffman.expand();
        }

    }
}
