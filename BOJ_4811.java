import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_4811 {
    static long[][] dp = new long[31][31];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            func(N, 0);
            System.out.println(dp[N][0]);
        }
    }

    // 안뇽~~
    private static long func(int w, int h) {
        if (w == 0 && h == 0) return 1;
        if(dp[w][h] != 0) return dp[w][h];

        if (w - 1 >= 0) dp[w][h] += func(w - 1, h + 1);
        if (h - 1 >= 0) dp[w][h] += func(w, h - 1);

        return dp[w][h];
    }
}