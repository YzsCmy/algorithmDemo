package foundation;

public class UnionFind {
    private int a[];
    private int sz[];
    private int count;
    UnionFind(int n){
        count = n;
        a = new int[n];
        sz = new int[n];
        for (int i = 0; i < n; i++) {
            a[i]=i;
        }

        for (int i = 0; i < n; i++) {
            sz[i]=1;
        }
    }

    public int count() {
        return count;
    }

    public boolean connection(int p,int q){
        return find(p)==find(q);
    }

    public int find(int s) {
       while(s!=a[s]){
           s=a[s];
       }
       return  s;
    }
    public void union(int p, int q){
        int pID = find(p);
        int qID = find(q);
        if(pID == qID)
            return;
        if(sz[pID]<sz[qID]){
            a[pID]=qID;
            sz[qID]+=sz[pID];
        }else{
            a[qID]=pID;
            sz[pID]+=sz[qID];
        }
        count--;
    }

}
