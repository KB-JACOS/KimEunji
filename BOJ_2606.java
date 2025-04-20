import java.io.*;
import java.util.*;

public class BOJ_2606 {
    static boolean[] visited;
    static ArrayList<Integer>[] nodeG;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int comN = Integer.parseInt(br.readLine());
        visited = new boolean[comN + 1];
        nodeG = new ArrayList[comN + 1];
        for (int i = 1; i < comN + 1; i++) {
            nodeG[i] = new ArrayList<>();
        }

        int coupleN = Integer.parseInt(br.readLine());
        for (int c = 1; c < coupleN + 1; c++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            nodeG[n1].add(n2);
            nodeG[n2].add(n1); //양방향!
        }
        dfs(1);

        int count = -1;
        for (boolean b : visited) {
            if (b) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static void dfs(int v) {
        if (visited[v]) return;

        visited[v] = true;
        for (int n : nodeG[v]) {
            if (!visited[n]) {
                dfs(n);
            }
        }
    }
}
