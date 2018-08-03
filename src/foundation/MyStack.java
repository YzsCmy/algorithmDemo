package foundation;

import java.util.Iterator;

public class MyStack<Item> implements Iterable<Item>{
    private Item[] coll = (Item[]) new Object[1];
    private int size;
    public boolean isEmpty(){
        return size==0;
    }
    public int size(){
        return size;
    }

    private void resize(int max){
        Item[] newItem = (Item[]) new Object[max];
        for (int i = 0; i < size; i++) {
            newItem[i] = coll[i];
        }
        coll=newItem;
    }
    public Item pop(){
        if(isEmpty()){
            System.out.println("stack is empty...");
            return null;
        }
        Item item = coll[--size];
        coll[size]=null;
        if(size>0&&size==coll.length/4)
            resize(coll.length/2);
        return item;
    }

    public void push(Item s){

        if(size==coll.length){
            resize(2*coll.length);
        }
        coll[size++]=s;

    }


    private class Itr implements Iterator<Item>{

        private int i;
        @Override
        public boolean hasNext() {
            return i<size;
        }

        @Override
        public Item next() {

            //int i = size();
            return coll[i++];
        }

        @Override
        public void remove() {

        }
    }
    @Override
    public Iterator<Item> iterator() {
        return new Itr();
    }

    public static void main(String[] args) {
        MyStack<String> fcos = new MyStack<>();
        System.out.println(fcos.pop());
        fcos.push("fdvdsf");
        fcos.push("fd");
        fcos.push("fdjhes");
        fcos.push("fds");
        fcos.push("ffgfdds");
        fcos.push("fdfgds");
        fcos.push("fdfhffgfs");
        fcos.push("fdfhs");
        fcos.push("ffhfds");
        fcos.push("fdhffhs");
        fcos.push("fds");
        for (String s: fcos) {
            System.out.println(s);
        }
    }
}
