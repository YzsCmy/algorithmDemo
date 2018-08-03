package foundation;

public class Testz {
    public static void main(String[] args) {
    /*    System.out.println('a');
        System.out.println("a"+'b');
        System.out.println((char)('a'+5));*/
        Date d1 = new Date(14,50,2017);
        System.out.println(d1);
    }
}
class Date{
    private final int value;
    public Date(int m,int d,int y){
        value=y*512+m*32+d;
    }
    public int month(){
        return (value/32)%16;
    }

    public int day(){
        return value%32;
    }

    public int year(){
        return value/512;
    }
    @Override
    public String toString() {
        return month()+"/"+day()+"/"+year();
    }

}