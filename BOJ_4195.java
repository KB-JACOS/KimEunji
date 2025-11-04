import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_4195 {
    static int[] parent, count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int k = 0; k < N; k++) {
            int F = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();

            int idx = 0;

            parent = new int[F*2];
            count = new int[F*2];

            for(int i = 0; i < F*2; i++){
                parent[i] = i;
                count[i] = 1;
            }

            for (int i = 0; i < F; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String s1 = st.nextToken(), s2 = st.nextToken();

                if (!map.containsKey(s1)) map.put(s1, idx++);
                if (!map.containsKey(s2)) map.put(s2, idx++);

                int idx1 = map.get(s1);
                int idx2 = map.get(s2);

                union(idx1, idx2);
                sb.append(count[find(idx1)]).append("\n");
            }
        }
        System.out.println(sb);
    }

    static int find(int x){
        if(parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }

    static void union(int a, int b){
        int pa = find(a), pb = find(b);
        if(pa == pb) return;

        parent[pb] = pa;
        count[pa] += count[pb];
    }
}