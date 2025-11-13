import java.util.*;
class programmers_보행자천국 {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityM) {
        int[][] cityMap = new int[m+1][n+1];
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                cityMap[i][j] = cityM[i-1][j-1];
            }
        }

        int[][] dp = new int[m+1][n+1];

        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(i==1 && j==1) {
                    dp[i][j] = 1;
                    continue;
                }

                if(cityMap[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }

                int a = dp[i-1][j], b =  dp[i][j-1];
                if(cityMap[i-1][j] == 2){
                    for(int k=i-1; k>=0; k--){
                        if(cityMap[k][j] == 1 || cityMap[k][j] == 0){
                            a = dp[k][j];
                            break;
                        }
                    }
                }

                if(cityMap[i][j-1] == 2) {
                    for(int k=j-1; k>=0; k--){
                        if(cityMap[i][k] == 1 || cityMap[i][k] == 0){
                            b = dp[i][k];
                            break;
                        }
                    }
                }

                dp[i][j] = (a+b) % MOD;
            }
        }

        return dp[m][n] % MOD;
    }
}