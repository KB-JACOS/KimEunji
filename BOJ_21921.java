import java.util.*;
import java.io.*;

public class BOJ_21921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] blog = new int[N+1];
        int[] sum = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            blog[i] = Integer.parseInt(st.nextToken());
            sum[i] = blog[i] + sum[i-1];
        }

        int max = 0; int count = 0;
        for(int i=X; i<=N; i++){
            int presum = sum[i] - sum[i-X];
            if(max < presum){
                max = presum;
                count = 1;
            } else if(max == presum){
                count ++;
            }
        }

        System.out.println((max==0)? "SAD" : max + "\n" + count);
    }
}
