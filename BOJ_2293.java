import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2293 {
    /// 3 10
    /// 1
    /// 2
    /// 5
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];
        int[] dp = new int[k + 1];

        //동전 저장
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        //dp
        dp[0]=1;
        for(int coin : coins){
            for(int i=1;i<=k;i++){
                int next = (i-coin >= 0)? dp[i-coin] : 0;
                dp[i] += next;
            }
        }

        System.out.println(dp[k]);
    }
}
