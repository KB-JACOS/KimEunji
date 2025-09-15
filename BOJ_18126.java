import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_18126 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<List<int[]>> list = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            list.get(start).add(new int[]{end, num});
            list.get(end).add(new int[]{start, num});
        }

        Queue<long[]> pq = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];

        pq.offer(new long[]{1, 0});
        visited[1] = true;

        long max = 0;
        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            max = Math.max(max, cur[1]);
            for (int[] li : list.get((int) cur[0])) {
                if (!visited[li[0]]) {
                    visited[li[0]] = true;
                    pq.offer(new long[]{li[0], cur[1] + li[1]});
                }
            }
        }
        System.out.println(max);
    }
}