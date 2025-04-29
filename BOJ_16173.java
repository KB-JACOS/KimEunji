import java.io.*;
import java.util.*;

public class BOJ_16173 {
    static int[][] array;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        array = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited[0][0] = true;
        bfs(0, 0);
        if (visited[n - 1][n - 1]) {
            System.out.println("HaruHaru");
        } else {
            System.out.println("Hing");
        }
    }

    public static void bfs(int i, int j) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{i, j});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int[] stepY = {array[now[1]][now[0]], 0};
            int[] stepX = {0, array[now[1]][now[0]]};
            for (int k = 0; k < 2; k++) {
                int y = now[0] + stepY[k];
                int x = now[1] + stepX[k];
                if (0 <= y && y < array.length && 0 <= x && x < array[0].length && !visited[y][x]) {
                    queue.offer(new int[]{y, x});
                    visited[y][x] = true;
                }
            }
        }
    }
}
