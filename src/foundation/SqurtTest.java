package foundation;

public class SqurtTest {

    public static void main(String[] args) {
        System.out.println(sqrt(9));
//        System.out.println(1e-15);

    }

    public static double sqrt(double c){
        if(c<0)
            return Double.NaN;
        double t=c;
        double err = 1e-15;
        while(Math.abs(t-c/t)>err*t){
            t = (c/t+t)/2.0;
        }
        return t;
    }
}
