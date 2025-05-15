import java.util.*;
class programmers_네트워크 {
    static int count = 0;
    static List<Integer>[] networkArr;
    static boolean[] visited;

    public static void dfs(int idx){
        if(visited[idx]){
            return;
        }

        visited[idx] = true;
        for(Integer i : networkArr[idx]){
            dfs(i);
        }
    }

    public int solution(int n, int[][] computers) {
        networkArr = new ArrayList[n];
        for(int i=0; i<n; i++){
            networkArr[i] = new ArrayList<Integer>();
            for(int j=0; j<n; j++){
                if(computers[i][j]==1 && i!=j) networkArr[i].add(j);
            }
        }

        visited = new boolean[n];
        for(int i=0; i<n; i++){
            if(!visited[i]) {
                dfs(i);
                count++;
            }
        }
        return count;
    }
}