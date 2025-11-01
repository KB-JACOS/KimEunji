import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_14889 {
    static int N;
    static int[][] nums;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N][N];
        visited = new boolean[N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                nums[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combinate(0, 0);
        System.out.println(min);
    }

    private static void combinate(int depth, int start){
        if(depth == N/2) {
            min = Math.min(min, countSum());
            return;
        }
        for(int i=start; i<N; i++){
            visited[i] = true;
            combinate(depth+1, i+1);
            visited[i] = false;
        }
    }

    private static int countSum(){
        int startSum = 0, linkSum = 0;
        for(int i=0; i<N; i++){
            for(int j=i+1; j<N; j++){
                if(visited[i] && visited[j]) {
                    startSum += nums[i][j];
                    startSum += nums[j][i];
                } else if(!visited[i] && !visited[j]) {
                    linkSum += nums[i][j];
                    linkSum += nums[j][i];
                }
            }
        }
        return Math.abs(startSum - linkSum);
    }
}
