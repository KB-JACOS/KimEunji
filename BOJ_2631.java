import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2631 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] children = new int[N];
        int[] dp = new int[N];
        for(int i = 0; i < N; i++) {
            dp[i] = 1;
        }

        for(int i = 0; i < N; i++) {
            children[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < i; j++) {
                if(children[i] > children[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 0;
        for(int i = 0; i < N; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(N-max);
    }
}
