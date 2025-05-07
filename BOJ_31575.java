import java.io.*;
import java.util.*;

public class BOJ_31575 {
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};

    static int n;
    static int m;

    static int[][] array;
    static boolean[][] visited;
    static boolean jb = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        array = new int[m][n];
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        if (jb) System.out.println("Yes");
        else System.out.println("No");
    }

    public static void dfs(int x, int y) {
        if (x == n - 1 && y == m - 1) {
            jb = true;
            return;
        }

        visited[y][x] = true;
        for (int i = 0; i < 2; i++) {
            int moveX = x + dx[i];
            int moveY = y + dy[i];
            if (0 <= moveX && moveX < n && 0 <= moveY && moveY < m && array[moveY][moveX] == 1 && !visited[moveY][moveX]) {
                dfs(moveX, moveY);
            }
        }
    }
}
