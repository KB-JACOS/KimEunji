import java.util.*;
import java.io.*;

public class BOJ_14267 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] boss = new int[n + 1];
        int[] dp = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num != -1) boss[i] = num;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            dp[a] += b;
        }
        for (int i = 1; i < n + 1; i++) {
            dp[i] += dp[boss[i]];
        }
        for (int i = 1; i < n + 1; i++) {
            sb.append(dp[i]).append(" ");
        }
        System.out.println(sb);
    }
}
