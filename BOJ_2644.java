import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2644 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int p1 = Integer.parseInt(st.nextToken());
        int p2 = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        List<List<Integer>> pcList = new ArrayList<>();
        for(int i=0; i<=n; i++) pcList.add(new ArrayList<>());

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            pcList.get(n1).add(n2);
            pcList.get(n2).add(n1);
        }

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n+1];
        for(int pc : pcList.get(p1)){
            queue.offer(new int[]{pc, 1});
        }
        while(!queue.isEmpty()){
            int[] cur = queue.poll();

            if(cur[0] == p2){
                System.out.println(cur[1]);
                return;
            }
            for(int pc : pcList.get(cur[0])){
                if(visited[pc]) continue;

                queue.offer(new int[]{pc, cur[1]+1});
                visited[pc] = true;
            }
        }
        System.out.println(-1);
    }
}
