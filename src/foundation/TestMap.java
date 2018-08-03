package foundation;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class TestMap {

    public static void main(String[] args) {
        final ConcurrentHashMap<Integer,String> concurrentHashMap = new ConcurrentHashMap<>();
        Thread t5 = new Thread(){
            public void run(){
                for (int i = 0; i < 20; i++) {
                    concurrentHashMap.put(i, String.valueOf(i));
                }
            }
        };
        Thread t6 = new Thread(){
            public void run(){
                for (int i = 20; i < 40; i++) {
                    concurrentHashMap.put(i, String.valueOf(i));
                }
            }
        };
        t5.start();
        t6.start();
        try{
            Thread.sleep(10);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        for (int i = 0; i < 40; i++) {
            System.out.println(i + "=" + concurrentHashMap.get(i));
        }
    }
}
