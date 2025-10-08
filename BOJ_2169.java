import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2169 {
    public static void main(St ring[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] nums = new int[N][M];
        int[][] dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                nums[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 첫 행은 그냥 합 (정방향 ->)
        dp[0][0] = nums[0][0];
        for (int j = 1; j < M; j++) {
            dp[0][j] = nums[0][j] + dp[0][j - 1];
        }

        for (int i = 1; i < N; i++) {
            int[][] tmp = new int[M][2]; // [j][0]: 왼쪽에서, [j][1]: 오른쪽에서

            //정방향 ->
            tmp[0][0] = dp[i - 1][0] + nums[i][0];
            for (int j = 1; j < M; j++) {
                // 위에서 내리거나 왼쪽에서 온거
                tmp[j][0] = Math.max(dp[i - 1][j], tmp[j - 1][0]) + nums[i][j];
            }

            //역방향 <-
            tmp[M - 1][1] = dp[i - 1][M - 1] + nums[i][M - 1];
            for (int j = M - 2; j >= 0; j--) {
                // 위에서 내리거나 오른쪽에서 온거
                tmp[j][1] = Math.max(dp[i - 1][j], tmp[j + 1][1]) + nums[i][j];
            }

            for (int j = 0; j < M; j++) {
                dp[i][j] = Math.max(tmp[j][0], tmp[j][1]);
            }

        }
        System.out.println(dp[N - 1][M - 1]);
    }
}