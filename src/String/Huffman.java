package String;

import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;
import edu.princeton.cs.algs4.MinPQ;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Huffman {

    private static final int R = 256;
    private static class Node implements Comparable<Node>{

        private final char ch;
        private final int fre;
        private final Node left,right;

        Node(char ch,int fre,Node left,Node right){
            this.ch = ch;
            this.fre = fre;
            this.left = left;
            this.right = right;
        }

        public boolean isLeaf(){
            return (this.left==null)&&(this.right==null);
        }
        @Override
        public int compareTo(Node o) {
            return this.fre-o.fre;
        }
    }

    private static void expand(){
        Node root = readTrie();
        int N = BinaryStdIn.readInt();
        for (int i = 0; i < N; i++) {
            Node x = root;
            while (!x.isLeaf()){
                if(BinaryStdIn.readBoolean()){
                    x = x.right;
                }else {
                    x = x.left;
                }
            }
            BinaryStdOut.write(x.ch);
        }
        BinaryStdOut.close();
    }


    private static void buildCode(String[] s,Node root,String x){
        if(root.isLeaf()){
            s[root.ch] = x;
            return;
        }
        buildCode(s,root.left,x+'0');
        buildCode(s,root.right,x+'1');
    }

    private static Node buildTrie(int[] freq){
        MinPQ<Node> pq = new MinPQ<>();
        for (char i = 0; i < R; i++) {
            if(freq[i]>0){
                pq.insert(new Node(i,freq[i],null,null));
            }
        }
        while (pq.size()>1){
            Node a = pq.delMin();
            Node b = pq.delMin();
            Node parent = new Node('\0',a.fre+b.fre,a,b);
            pq.insert(parent);
        }
        return pq.delMin();
    }

    private static void writeTrie(Node x){
        if(x.isLeaf()){
            BinaryStdOut.write(true);
            BinaryStdOut.write(x.ch,8);
            return;
        }
        BinaryStdOut.write(false);
        writeTrie(x.left);
        writeTrie(x.right);
    }

    private static Node readTrie(){

        if(BinaryStdIn.readBoolean()){
            return new Node(BinaryStdIn.readChar(),-1,null,null);
        }else{
            return new Node('\0',-1,readTrie(),readTrie());
        }
    }

    public static void compress(){
        String s = BinaryStdIn.readString();
        char[] input = s.toCharArray();
        int[] freq = new int[R];
        for (int i = 0; i < input.length; i++) {
            freq[input[i]]++;
        }
        Node root = buildTrie(freq);

        String[] st = new String[R];

        buildCode(st,root,"");

        writeTrie(root);

        BinaryStdOut.write(input.length);

        for (int i = 0; i < input.length; i++) {
            String code = st[input[i]];
            for (int j = 0; j < code.length(); j++) {
                if(code.charAt(j)=='1'){
                    BinaryStdOut.write(true);
                }else if(code.charAt(j)=='0'){
                    BinaryStdOut.write(false);
                }
            }
        }
        BinaryStdOut.close();
    }

    public static void main(String[] args) {

        if("-".equals(args[0])){
            try {
                BufferedInputStream in = new BufferedInputStream(new FileInputStream("C:\\Users\\yzs\\Desktop\\a.jpg"));
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
                PrintStream printStream = new PrintStream(new FileOutputStream("C:\\Users\\yzs\\Desktop\\b.jpg"));
                System.setOut(printStream);
            }catch (Exception e){
            }
            expand();
        }

    }

}
