import java.io.*;
import java.util.*;

public class BOJ_14500 {
    static int[] moveX = {0, 0, -1, 1};
    static int[] moveY = {-1, 1, 0, 0};

    static boolean[][] visited;

    static int[][] intArray;
    static int max=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        intArray = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                intArray[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                dfs(i, j, i, j, 1, intArray[i][j]);
                visited[i][j] = false;
            }
        }
        System.out.println(max);
    }

    public static void dfs(int curY, int curX, int prevY, int prevX, int depth, int total) {
        if(depth == 4){
            max = Math.max(total, max);
            return;
        }

        for (int j = 0; j < 4; j++) {
            int curNextX = curX + moveX[j];
            int curNextY = curY + moveY[j];

            if(curNextX>=0 && curNextX<intArray[0].length && curNextY>=0 && curNextY<intArray.length  && !visited[curNextY][curNextX]) {
                visited[curNextY][curNextX] = true;
                dfs(curNextY, curNextX, curY, curX, depth + 1, total + intArray[curNextY][curNextX]);
                visited[curNextY][curNextX] = false;
            }

            int prevNextX = prevX + moveX[j];
            int prevNextY = prevY + moveY[j];

            if (!(prevNextX == curNextX && prevNextY == curNextY)) {
                if (prevNextX >= 0 && prevNextX < intArray[0].length && prevNextY >= 0 && prevNextY < intArray.length && !visited[prevNextY][prevNextX]) {
                    visited[prevNextY][prevNextX] = true;
                    dfs(prevNextY, prevNextX, prevY, prevX, depth + 1, total + intArray[prevNextY][prevNextX]);
                    visited[prevNextY][prevNextX] = false;
                }
            }
        }
    }
}
