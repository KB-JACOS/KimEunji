import java.util.*;
import java.io.*;

public class BOJ_1103 {
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    private static boolean[][] visited;
    private static int[][] num, dp;
    private static int N, M, result = 0;
    private static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new int[N][M];
        dp = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                if(str.charAt(j) == 'H') num[i][j] = -1; // HOLE
                else num[i][j] = str.charAt(j) - '0';
            }
        }
//        System.out.println(Arrays.deepToString(num));

        visited[0][0] = true;
        dfs(0,0, 0);

        System.out.println(flag? -1 : result);
    }

    private static void dfs(int r, int c, int count){
        if(flag) return;

        for(int i=0; i<4; i++) {
            int nextR = r + dr[i] * num[r][c];
            int nextC = c + dc[i] * num[r][c];

            // 범위 벗어나거나 구멍이면 반환
            if (!(0 <= nextR && nextR < N && 0 <= nextC && nextC < M) || num[nextR][nextC] == -1) {
                result = Math.max(result, count + 1);
                continue; // 다른 탐색으로
            }

            // 현재 값이 dp보다 작으면 안가도됨
            if (dp[nextR][nextC] >= count + 1) continue;

            // 이미 방문했으면 무한
            if (visited[nextR][nextC]) {
                flag = true;
                return; // 중단
            }

            visited[nextR][nextC] = true;
            dp[nextR][nextC] = count + 1;
            dfs(nextR, nextC, count + 1);
            visited[nextR][nextC] = false;
        }
    }
}
