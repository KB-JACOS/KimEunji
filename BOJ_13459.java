import java.util.*;
import java.io.*;
public class BOJ_13459 {
    static int N;
    static int M;
    static int[] dr = {0,0,-1,1};
    static int[] dc = {-1,1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // input -> map에 넣기
        int redR = 0, redC = 0;
        int blueR = 0, blueC = 0;

        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                char ch = line.charAt(j);
                if (ch == 'R') {
                    redR = i;
                    redC = j;
                } else if (ch == 'B') {
                    blueR = i;
                    blueC = j;
                }
                map[i][j] = line.charAt(j);
            }
        }

        //queue 돌리기
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][][][] visited = new boolean[N][M][N][M];
        q.offer(new int[]{redR, redC, blueR, blueC, 0});
        visited[redR][redC][blueR][blueC] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int currR = cur[0], currC = cur[1], curbR = cur[2], curbC = cur[3], curStep = cur[4];

            // 10번까지 도전
            if (curStep >= 10) {
                System.out.println(0);
                return;
            }

            for (int i = 0; i < 4; i++) {
                boolean enableRed = false, enableBlue = false;
                //빨강
                int nextrR = currR + dr[i], nextrC = currC + dc[i];
                while (true) {
                    if (map[nextrR][nextrC] == '#') {
                        nextrR -= dr[i];
                        nextrC -= dc[i];
                        break;
                    }
                    if (map[nextrR][nextrC] == 'O') {
                        enableRed = true;
                        break;
                    }
                    nextrR += dr[i];
                    nextrC += dc[i];
                }

                //파랑
                int nextbR = curbR + dr[i], nextbC = curbC + dc[i];
                while (true) {
                    if (map[nextbR][nextbC] == '#') {
                        nextbR -= dr[i];
                        nextbC -= dc[i];
                        break;
                    }
                    if (map[nextbR][nextbC] == 'O') {
                        enableBlue = true;
                        break;
                    }
                    nextbR += dr[i];
                    nextbC += dc[i];
                }

                //들어가는지 확인
                if (enableBlue) continue;
                if (enableRed) {
                    System.out.println(1);
                    return;
                }

                int redDist = Math.abs(currR - nextrR) + Math.abs(currC - nextrC);
                int blueDist = Math.abs(curbR - nextbR) + Math.abs(curbC - nextbC);

                // 많이 움직인거 기준으로 -(반대) 방향으로 움직여
//                if (nextrR == nextbR && nextrC == nextbC) {
//                    if (redDist < blueDist) {
//                        nextbR -= dr[i];
//                        nextbC -= dc[i];
//                    } else {
//                        nextrR -= dr[i];
//                        nextrC -= dc[i];
//                    }
//                }
                if(nextrR == nextbR && nextrC == nextbC){
                    //row
                    if(dr[i] == -1){
                        if(currR > curbR) nextrR += 1;
                        else if(currR < curbR) nextbR += 1;
                    }
                    if(dr[i] == 1){
                        if(currR > curbR) nextbR -= 1;
                        else if(currR < curbR) nextrR -= 1;
                    }
                    if(dc[i] == -1){
                        if(currC > curbC) nextrC += 1;
                        else if(currC < curbC) nextbC += 1;
                    }
                    if(dc[i] == 1){
                        if(currC > curbC) nextbC -= 1;
                        else if(currC < curbC) nextrC -= 1;
                    }
                }

                //큐에 넣기
                if (!visited[nextrR][nextrC][nextbR][nextbC]) {
                    q.offer(new int[]{nextrR, nextrC, nextbR, nextbC, curStep + 1});
                    visited[nextrR][nextrC][nextbR][nextbC] = true;
                }
            }
        }
        System.out.println(0);
    }
}
