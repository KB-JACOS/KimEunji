import java.io.*;
import java.util.*;

public class BOJ_19637 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] name = new String[N];
        int[] power = new int[N];

        int size = 0;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            String s = st.nextToken();
            int n = Integer.parseInt(st.nextToken());

            if(size==0 || power[size-1]!=n){
                name[size] = s;
                power[size] = n;
                size++;
            }
        }
        //System.out.println(Arrays.toString(power));

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            int num = Integer.parseInt(br.readLine());

            int bs = Arrays.binarySearch(power, 0, size, num);
            if(bs < 0) bs = - bs - 1;

            sb.append(name[bs]).append("\n");
        }
        System.out.println(sb);
    }
}
