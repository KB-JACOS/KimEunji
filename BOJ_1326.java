import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1326 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int [] stones = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            stones[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()) -1;
        int end = Integer.parseInt(st.nextToken()) -1;

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[N];

        queue.offer(new int[]{start, 0});
        visited[start] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int pos = cur[0], cnt = cur[1];
            if(pos == end) {
                System.out.println(cnt);
                return;
            }

            int step = stones[pos]; //값

            for(int i=1; pos + step*i < N; i++){
                if(!visited[pos + step*i]){
                    queue.offer(new int[]{pos + step*i, cnt+1});
                    visited[pos + step*i] = true;
                }
            }
            for(int i=1; pos - step*i >= 0; i++){
                if(!visited[pos - step*i]){
                    queue.offer(new int[]{pos - step*i, cnt+1});
                    visited[pos - step*i] = true;
                }
            }
        }
        System.out.println(-1);
    }
}
