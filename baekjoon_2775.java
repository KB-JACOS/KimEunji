import java.util.*;
import java.lang.*;
import java.io.*;

public class baekjoon_2775 {
    static int[][] dp = new int[15][15];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        
        for(int i=1; i<=14; i++){
            dp[0][i]=i;
        }

        for(int a=1; a<=14; a++){
            for(int b=1; b<=14; b++){
                dp[a][b]=dp[a-1][b]+dp[a][b-1];
            }
        }
        
        for(int t=0; t<T; t++){
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[k][n]);
        }
    }
}
