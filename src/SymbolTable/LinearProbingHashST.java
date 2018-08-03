package SymbolTable;

public class LinearProbingHashST<Key,Value> {
    private final static int INICAP = 4;
    private int n;//size of key-values
    private int m;//size of table
    private Key[] keys;
    private Value[] values;

    public LinearProbingHashST(){
        this(INICAP);
    }
    public LinearProbingHashST(int cap){
        keys = (Key[]) new Object[cap];
        values = (Value[]) new Object[cap];
        this.m = cap;
    }

    private void resize(int cap){
        LinearProbingHashST<Key,Value> temp= new LinearProbingHashST<>(cap);
        for (int i = 0; i < m; i++) {
            if(keys[i]!=null){
                temp.put(keys[i],values[i]);
            }
        }
        keys = temp.keys;
        values = temp.values;
        this.m = temp.m;
    }

    public boolean contains(Key k){
        return get(k)!=null;
    }

    private int hash(Key k){
        return (k.hashCode()&0x7fffffff)%m;
    }

    public void put(Key k, Value v){
        if(n>=m/2){
            resize(2*m);
        }
        int i;
        for(i = hash(k);keys[i]!=null;i=(i+1)%m){
            if(keys[i].equals(k)){
                values[i] = v;
                return;
            }
        }
        keys[i] = k;
        values[i] = v;
        n++;
    }

    public Value get(Key k){
        for(int i = hash(k);keys[i]!=null;i=(i+1)%m){
            if(keys[i].equals(k)){
                return values[i];
            }
        }
        return null;
    }

    public void delete(Key k){
        if(!contains(k)){
            return;
        }
        int h = hash(k);
        while (keys[h]!=k){
            h=(h+1)%m;
        }
        keys[h]=null;
        values[h]=null;
        h=(h+1)%m;
        while (keys[h]!=null){
            Key redoKey = keys[h];
            Value redoVal = values[h];
            keys[h] = null;
            values[h] = null;
            n--;
            put(redoKey,redoVal);
            h=(h+1)%m;
        }
        n--;
        if(m>0&&n==m/8){
            resize(m/2);
        }
    }
}
