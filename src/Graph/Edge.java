package Graph;

public class Edge implements Comparable<Edge>{
    private final int v;
    private final int w;
    private final double weight;

    public Edge(int v,int w,double weight){
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double weight(){
        return weight;
    }

    public int either(){
        return v;
    }

    public int other(int ver){
        if(ver == v){
            return w;
        }else if(ver == w){
            return v;
        }else{
            throw  new RuntimeException("no such edge!");
        }
    }


    @Override
    public int compareTo(Edge o) {

        return this.weight>o.weight?1:(this.weight<o.weight?-1:0);
    }

    @Override
    public String toString() {
        return String.format("%d-%d %.2f",v,w,weight);
    }
}
