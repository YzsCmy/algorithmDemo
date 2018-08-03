package SymbolTable;

public class RedBlackBST<Key extends Comparable<Key>, Value> {

    private Node root;
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node{
        private Key key;
        private Value val;
        int n;
        Node left,right;
        boolean color;
        public Node(Key k, Value v, int s, boolean c){
            key = k;
            val = v;
            n = s;
            color = c;
        }
    }

    public int size(){
        return size(root);
    }

    private int size(Node k){
        if(k==null){
            return 0;
        }else{
            return k.n;
        }

    }

    public boolean isEmpty() {
        return root == null;
    }

    private boolean isRed(Node s){
        if(s==null){
            return false;
        }
        return s.color==RED;
    }

    private void flipColor(Node f){
        f.color = !f.color;
        f.left.color = !f.left.color;
        f.right.color = !f.right.color;
    }

    private Node rotateLeft(Node h){

        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.n=h.n;
        h.n = size(h.left)+size(h.right)+1;
        return x;
    }

    private Node rotateRight(Node h){
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.n=h.n;
        h.n = size(h.left)+size(h.right)+1;
        return x;
    }

    public void put(Key k, Value v){
        root = put(root,k,v);
    }

    private Node put(Node h, Key k, Value v){
        if(h==null){
            return new Node(k,v,1,RED);
        }

        int cmp = k.compareTo(h.key);
        if(cmp<0){
            h.left = put(h.left,k,v);
        }else if(cmp>0){
            h.right = put(h.right,k,v);
        }else{
            h.val = v;
        }

        if(isRed(h.right)&&!isRed(h.left)){
            h = rotateLeft(h);
        }

        if(isRed(h.left)&&isRed(h.left.left)){
            h = rotateRight(h);
        }

        if(isRed(h.left)&&isRed(h.right)){
            flipColor(h);
        }
        h.n = size(h.right)+size(h.left)+1;
        return h;
    }

    private Node moveRedLeft(Node h){
        flipColor(h);
        if(isRed(h.right.left)){
            h.right = rotateRight(h.right);
            h = rotateLeft(h);
            flipColor(h);
        }
        return h;
    }

    private Node moveRedRight(Node h){
        flipColor(h);
        if(isRed(h.left.left)){
            h=rotateRight(h);
            flipColor(h);
        }
        return h;
    }

    private Node balance(Node h) {

        if (isRed(h.right))                      h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right))     flipColor(h);

        h.n = size(h.left) + size(h.right) + 1;
        return h;
    }

    public void deleteMin(){
        if(!isRed(root.left)&&!isRed(root.right)){
            root.color = RED;
        }
        root = deleteMin(root);
        if(!isEmpty()){
            root.color = BLACK;
        }
    }
    private Node deleteMin(Node k){
        if(k.left==null){
            return null;
        }

        if(!isRed(k.left)&&!isRed(k.left.left)){
            moveRedLeft(k);
        }

        k = deleteMin(k);
        return balance(k);
    }

    public void deleteMax(){
        if(!isRed(root.left)&&!isRed(root.right)){
            root.color = RED;
        }
        root = deleteMin(root);
        if(!isEmpty()){
            root.color = BLACK;
        }
    }

    private Node deleteMax(Node h){
        if(isRed(h.left)){
            rotateRight(h);
        }
        if(h.right==null){
            return null;
        }
        if(!isRed(h.right)&&!isRed(h.right.left)){
            moveRedRight(h);
        }
        h.right = deleteMax(h.right);
        return balance(h);
    }
}
