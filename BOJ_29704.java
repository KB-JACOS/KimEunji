import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_29704 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N =  Integer.parseInt(st.nextToken());
        int T =  Integer.parseInt(st.nextToken());

        int[][] dp = new int[N+1][T+1];
        int sum = 0;
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            for(int j=1; j<=T; j++){
                if(j-a<0) dp[i][j] = dp[i-1][j];
                else dp[i][j] = Math.max(dp[i-1][j-a]+b, dp[i-1][j]); // 넣은거, 안넣은거
            }
            sum += b;
        }
        //System.out.println(Arrays.deepToString(dp));
        System.out.println(sum - dp[N][T]);
    }
}
