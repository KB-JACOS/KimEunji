import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//sol. dfs
public class BOJ_1182_dfs {
    static int N, S, count;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++){
            dfs(i, nums[i]);
        }
        System.out.println(count);
    }

    static void dfs(int idx, int sum) {
        if(sum == S){
            count++;
        }
        if(idx == N-1){
            return;
        }
        for(int i = 1; i+idx < N; i++){
            dfs(i + idx, sum + nums[i+idx]);
        }
    }
}
