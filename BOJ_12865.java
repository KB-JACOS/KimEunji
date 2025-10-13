import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int max = Integer.parseInt(st.nextToken());
        int[][] dp = new int[N+1][max+1];

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());

            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            for(int j=0; j<=max; j++){
                if(j-w < 0) dp[i][j] = dp[i-1][j];
                else dp[i][j] = Math.max(dp[i-1][j-w] + v, dp[i-1][j]);
            }
            //System.out.println(Arrays.deepToString(dp));
        }
        System.out.println(dp[N][max]);
    }
}
