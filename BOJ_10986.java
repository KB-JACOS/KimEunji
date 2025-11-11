import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] sums = new long[N +1];
        long[] counts = new long[M]; counts[0] = 1;

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            sums[i] = (sums[i-1] + Long.parseLong(st.nextToken())) % M;
            counts[(int) sums[i]]++;
        }

        long answer = 0;
        for(long count : counts){
            if(count >= 2) answer += (count * (count-1)/2);
        }

        System.out.print(answer);
    }
}