import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1260 {
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<=N; i++) list.add(new ArrayList<>());
        visited = new boolean[N+1];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list.get(start).add(end);
            list.get(end).add(start);
        }

        for(List<Integer> l: list) l.sort((a, b) -> (a - b));

        dfs(V, list);
        System.out.println();

        bfs(V, list);
    }

    private static void bfs(int V, List<List<Integer>> list){
        Queue<Integer> queue = new LinkedList<>();
        Arrays.fill(visited, false);

        queue.add(V);
        visited[V] = true;

        while(!queue.isEmpty()){
            int cur = queue.poll();
            System.out.print(cur + " ");

            for(Integer point : list.get(cur)){
                if(!visited[point]){
                    visited[point] = true;
                    queue.add(point);
                }
            }
        }
    }

    private static void dfs(int V, List<List<Integer>> list){
        visited[V] = true;
        System.out.print(V + " ");

        for(Integer point : list.get(V)){
            if(!visited[point]){
                visited[point] = true;
                dfs(point, list);
            }
        }
    }
}
