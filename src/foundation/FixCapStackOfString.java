package foundation;

import java.util.Iterator;

public class FixCapStackOfString implements Iterable<String>{
    private String[] coll;
    private int size;
    public FixCapStackOfString(int cap){
        coll = new String[cap];
    }
    public boolean isEmpty(){
        return size==0;
    }
    public int size(){
        return size;
    }

    public String pop(){
        if(isEmpty())
        {
            return ("stack is empty...");
        }
        String item = coll[--size];
        coll[size]=null;
        return item;
    }

    public void push(String s){
        if(size==coll.length)
        {
            System.out.println("stack is full...");
        }else {
            coll[size++]=s;
        }
    }

    @Override
    public Iterator<String> iterator() {

        class Itr<T> implements Iterator<String>{

            int i;
            @Override
            public boolean hasNext() {
                return i<size;
            }

            @Override
            public String next() {

                //int i = size();
                return coll[i++];
            }

            @Override
            public void remove() {

            }
        }
        return new Itr<String>();
    }

    public static void main(String[] args) {
        FixCapStackOfString fcos = new FixCapStackOfString(3);
        System.out.println(fcos.pop());
        fcos.push("fdvdsf");
        fcos.push("fd");
        //fcos.push("fdetwsf");
        fcos.push("fds");
        //fcos.pop();
        for (String s: fcos) {
            System.out.println(s);
        }
    }

}
