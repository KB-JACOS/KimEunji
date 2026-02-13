import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2616 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] guest = new int[N+1];
        int[] guestSum = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            guest[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=1; i<=N; i++){
            guestSum[i] = guest[i] + guestSum[i-1];
        }

        int maxTrain = Integer.parseInt(br.readLine());

        int[] slice = new int[N+1];
        for(int i=maxTrain; i<=N; i++){
            slice[i] = guestSum[i]-guestSum[i-maxTrain];
        }
        //System.out.println(Arrays.toString(slice));

        int[][] dp = new int[4][N+1];
        for(int i=maxTrain; i<=N; i++){
            dp[1][i] = Math.max(dp[1][i-1], slice[i]);
            dp[2][i] = Math.max(dp[2][i-1], dp[1][i-maxTrain] + slice[i]);
            dp[3][i] = Math.max(dp[3][i-1], dp[2][i-maxTrain] + slice[i]);
        }
        //System.out.println(Arrays.deepToString(dp));
        System.out.println(dp[3][N]);
    }
}
