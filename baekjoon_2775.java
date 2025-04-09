import java.util.*;
import java.lang.*;
import java.io.*;

public class baekjoon_2775 {
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int k=1;
        int n=1;
        for(int t=0; t<T; t++){
            k = Integer.parseInt(br.readLine());
            n = Integer.parseInt(br.readLine());
            
            dp = new int[k+1][15];
            for(int i=1; i<=14; i++){
                dp[0][i]=i;
            }
            apartment(k,n);
        }
    }
    public static void apartment(int k, int n){
        for(int a=1; a<=k; a++){
            for(int c=1; c<=n; c++){
                for(int b=1; b<=c; b++){
                    dp[a][c]+=dp[a-1][b];
                }
            }
        }
        
        System.out.println(dp[k][n]);
    }
}
