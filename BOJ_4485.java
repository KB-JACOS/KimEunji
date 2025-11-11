import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_4485 {
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int count = 1;
        while(true){
            //반복
            int N = Integer.parseInt(br.readLine());
            if(N == 0) break;

            //입력
            int[][] cave = new int[N][N];
            int[][] sum = new int[N][N];
            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    cave[i][j] = Integer.parseInt(st.nextToken());
                    sum[i][j] = N*9;
                }
            }
            sum[0][0] = cave[0][0];

            //구현
            Queue<int[]> q = new ArrayDeque<>();
            q.offer(new int[]{0, 0, cave[0][0]});

            while(!q.isEmpty()){
                int[] cur = q.poll();
                int r = cur[0], c = cur[1], w = cur[2];

                //pass
                if(sum[r][c] < w) continue; //이미 더 작은 경로라서 pass
                if(r == N-1 && c == N-1) continue;

                for(int i=0; i<4; i++){
                    int nr = r + dr[i], nc = c + dc[i];
                    if(!(nr >= 0 && nr < N && nc >= 0 && nc < N)) continue;

                    int nw = w + cave[nr][nc];
                    if(sum[nr][nc] <= nw) continue;
                    sum[nr][nc] = nw;

                    q.offer(new int[]{nr, nc, sum[nr][nc]});
                }
            }
            sb.append("Problem " + count++ + ": " + sum[N-1][N-1]).append("\n");
        }
        System.out.println(sb);
    }
}