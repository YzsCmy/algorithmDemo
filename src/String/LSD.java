package String;

public class LSD {
    public static void sort(String[] a,int w){
        int N = a.length;
        int R = 256;
        String[] aux = new String[N];
        for (int x = w-1; x >= 0; x--){
            int[] count = new int[R+1];
            for (int i = 0; i < N; i++) {
                count[a[i].charAt(x)+1]++;
            }
            for (int i = 0; i < R; i++) {
                count[i+1] += count[i];
            }

            for (int i = 0; i < N; i++) {
                aux[count[a[i].charAt(x)]++] = a[i];
            }

            for (int i = 0; i < N; i++) {
                a[i] = aux[i];
            }
        }
    }

    public static void main(String[] args) {
        String[] stus = { "fnc","cac","edb","oel","akf","erk"};
        //int s = stus[1].charAt(1);
        //System.out.println(s);
        LSD.sort(stus,3);

        for(String s:stus){
            System.out.println(s);
        }
    }
}
