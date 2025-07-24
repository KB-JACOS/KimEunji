import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_14567 {
    static int N;
    static int[] dp;
    static List<List<Integer>> list = new ArrayList<>();
    static Queue<int[]> queue;
    static int[] parentCount;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        dp = new int[N+1];
        for(int i = 0; i <= N; i++){
            list.add(new ArrayList<>());
        }

        parentCount = new int[N+1];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.get(x).add(y);
            parentCount[y] ++;
        }

        queue = new ArrayDeque<>();
        for(int i=1; i<=N; i++){
            if(parentCount[i] == 0){
                dp[i] = 1;
                queue.add(new int[]{i, 1});
            }
        }
        bfs();

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            sb.append(dp[i]).append(" ");
        }
        System.out.println(sb);
    }

    public static void bfs(){
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curS = cur[0], curD = cur[1];

            for(Integer l : list.get(curS)){
                parentCount[l]--;
                if(parentCount[l] == 0) {
                    queue.add(new int[]{l, curD + 1});
                    dp[l] = Math.max(dp[l], curD + 1);
                }
            }
        }
    }
}
