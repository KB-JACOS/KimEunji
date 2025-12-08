import java.util.*;
import java.lang.*;
import java.io.*;

public class BOJ_11967 {
    static int N;
    static int[] dr = {-1, 0, 0, 1};
    static int[] dc = {0, -1, 1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<int[]>[][] list = new ArrayList[N+1][N+1];
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                list[i][j] = new ArrayList<>();
            }
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int startR = Integer.parseInt(st.nextToken());
            int startC = Integer.parseInt(st.nextToken());
            int endR = Integer.parseInt(st.nextToken());
            int endC = Integer.parseInt(st.nextToken());

            list[startR][startC].add(new int[]{endR, endC});
        }

        boolean[][] visited = new boolean[N+1][N+1];
        boolean[][] lightOn = new boolean[N+1][N+1];

        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[]{1,1});
        visited[1][1] = true;
        lightOn[1][1] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curR = cur[0], curC = cur[1];

            // 불 켜기
            for(int[] arr : list[curR][curC]){
                int tmpR = arr[0], tmpC = arr[1];

                if(!lightOn[tmpR][tmpC]){
                    lightOn[tmpR][tmpC] = true;

                    for(int i=0; i<4; i++) {
                        int nextR = tmpR + dr[i], nextC = tmpC + dc[i];
                        if (inBound(nextR, nextC) && visited[nextR][nextC] && !visited[tmpR][tmpC]) {
                            q.offer(new int[]{tmpR, tmpC});
                            visited[tmpR][tmpC] = true;
                        }
                    }
                }
            }

            // 내 주변 불 킨 방 중에서 갈 수 있는 곳
            for(int i=0; i<4; i++) {
                int nextR = curR + dr[i], nextC = curC + dc[i];
                if (inBound(nextR, nextC) && lightOn[nextR][nextC] && !visited[nextR][nextC]) {
                    q.offer(new int[]{nextR, nextC});
                    visited[nextR][nextC] = true;
                }
            }
        }

        // 불 켜진 곳의 수
        int count = 0;
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(lightOn[i][j]) count ++;
            }
        }
        System.out.println(count);
    }
    static boolean inBound(int r, int c){
        return 1 <= r && r <= N && 1 <= c && c <= N;
    }
}
