import java.io.*;
import java.util.*;

public class BOJ_2178 {
    static final int[] di = {-1, 1, 0, 0};
    static final int[] dj = {0, 0, -1, 1};

    static int[][] array;
    static boolean[][] visited;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        array = new int[n][m];
        visited = new boolean[n][m];
        dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                array[i][j] = Integer.parseInt(temp[j]);
            }
        }

        visited[0][0] = true;
        bfs(0,0);
        System.out.println(dist[n-1][m-1] + 1);
    }
    public static void bfs(int i, int j){
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        visited[i][j] = true;
        queue.offer(new int[] {i,j});

        while(!queue.isEmpty()){
            int[] now =  queue.poll();
            for(int k=0; k<4; k++){
                int x = now[0] + di[k];
                int y = now[1] + dj[k];
                if(x>=0 && x<array[0].length && y>=0 && y<array.length){
                    if(!visited[y][x] && array[y][x]==1){
                        visited[y][x] = true;
                        dist[y][x] = dist[now[1]][now[0]] + 1;
                        queue.offer(new int[] {x,y});
                    }
                }
            }
        }
    }
}
