import java.util.*;
import java.io.*;

public class BOJ_2098 {
    static int[][] num;
    static int[][] dp;
    static int answer = Integer.MAX_VALUE, n;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        num = new int[n][n];

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0; j<n; j++){
                int a = Integer.parseInt(st.nextToken());
                num[i][j] = (a == 0)? Integer.MAX_VALUE : a;
            }
        }

        // 코드 구현
        dp = new int[1 << n][n];
        for(int[] d : dp){
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        dfs(0, 0, 0);

        System.out.println(answer);
    }
    private static void dfs(int start, int path, int count){
        path |= (1 << start);

        // 종료 : 다 돌고 내 값으로 돌아와야 함
        if(path == ((1 << n) - 1)){
            if(num[start][0] != Integer.MAX_VALUE)
                answer = Math.min(answer, count + num[start][0]);
            return;
        }

        for(int i=0; i<n; i++){
            // 이미 방문한 곳이면 패스
            if((path & (1 << i)) != 0) continue;

            // 못가니깐 패스
            if(num[start][i] == Integer.MAX_VALUE) continue;

            // 저장된 값보다 작지 않아서 패스
            if(dp[path][i] <= count + num[start][i]) continue;

            dp[path][i] = count + num[start][i];
            dfs(i, path, count + num[start][i]);
        }
    }
}
