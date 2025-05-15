import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr =  new int[n][3];
        int[][] dp = new int[n][3];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(i==0) dp[i][j] = arr[i][j];
                else{
                    dp[i][j] = arr[i][j] + Math.min(dp[i-1][(j+1) % 3], dp[i-1][(j+2) % 3]);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i : dp[n-1]){
            min = Math.min(min, i);
        }
        System.out.println(min);
    }
}
