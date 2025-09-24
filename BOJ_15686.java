import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_15686 {
    static int N, M;
    static int[][] dist;
    static int answer = Integer.MAX_VALUE;

    static List<int[]> homes, chickens;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist = new int[N][N];
        homes = new ArrayList<>();
        chickens = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                dist[i][j] = Integer.parseInt(st.nextToken());
                if (dist[i][j] == 1) homes.add(new int[]{i, j});
                if (dist[i][j] == 2) chickens.add(new int[]{i, j});
            }
        }

        combination(0, chickens.size(), 0, new ArrayList<>());
        System.out.println(answer);
    }

    static void combination(int start, int size, int depth, List<Integer> tmp) {
        if (depth == M) {
            answer = Math.min(answer, sumDist(tmp));
            return;
        }

        for (int i = start; i < size; i++) {
            tmp.add(i);
            combination(i + 1, size, depth + 1, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }

    static int sumDist(List<Integer> com) {
        int tmp = 0;
        for (int[] home : homes) {
            int dist = Integer.MAX_VALUE;
            for (Integer i : com) {
                dist = Math.min(dist,
                        Math.abs(home[0] - chickens.get(i)[0]) + Math.abs(home[1] - chickens.get(i)[1]));
            }
            tmp += dist;
        }
        return tmp;
    }
}
