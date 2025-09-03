import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_7576 {
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] box = new int[M][N];
        List<int[]> ripe = new ArrayList<>();

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                box[j][i] = Integer.parseInt(st.nextToken());
                if(box[j][i]==1) {
                    ripe.add(new int[]{j, i});
                }
            }
        }

        Queue<int[]> q = new ArrayDeque<>();
        for(int[] tmp : ripe){
            q.offer(new int[]{tmp[0], tmp[1], 0});
        }

        int depth = 0;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            depth = cur[2];
            for(int i=0; i<4; i++) {
                int nextR = cur[0] + dr[i];
                int nextC = cur[1] + dc[i];
                if(0<=nextR && nextR<M && 0<=nextC && nextC<N ) {
                    if(box[nextR][nextC]==0) {
                        q.offer(new int[]{nextR, nextC, depth+1});
                        box[nextR][nextC] = 1;
                    }
                }
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(box[j][i]==0){
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(depth);
    }
}
