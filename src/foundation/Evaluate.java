package foundation;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;

public class Evaluate {

    public static void main(String[] args) {
        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();
        while (!StdIn.isEmpty()){
            String s = StdIn.readString();
            if(s.equals("(")) ;
            else if(s.equals("+"))  ops.push(s);//( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )
            else if(s.equals("-"))  ops.push(s);
            else if(s.equals("*"))  ops.push(s);
            else if(s.equals("/"))  ops.push(s);
            else if(s.equals(")")){
                String o = ops.pop();
                Double val = vals.pop();
                if(o.equals("+"))  val = vals.pop()+val;
                else if(o.equals("-"))  val = vals.pop()-val;
                else if(o.equals("*"))  val = vals.pop()*val;
                else if(o.equals("/"))  val = vals.pop()/val;
                vals.push(val);
            }else{
                vals.push(Double.parseDouble(s));
            }
        }
        StdOut.println(vals.pop());
    }
}
