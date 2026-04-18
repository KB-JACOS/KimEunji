import java.util.*;
import java.io.*;

public class BOJ_34118 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        boolean[] korea = new boolean[N+1];
        boolean[] all = new boolean[N+1];

        String str = br.readLine();
        for(int i=1; i<=N; i++){
            korea[i] = (str.charAt(i-1) == '1')? true : false;
        }

        str = br.readLine();
        for(int i=1; i<=N; i++){
            all[i] = (str.charAt(i-1) == '1')? true : false;
        }

        //System.out.println(Arrays.toString(korea));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int p1 = Integer.parseInt(st.nextToken());
        int p3 = Integer.parseInt(st.nextToken());
        int p5 = Integer.parseInt(st.nextToken());
        int pp = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N+1][N+1];

        for(int i=0;i<=N;i++)
            Arrays.fill(dp[i], Integer.MAX_VALUE);

        dp[0][0] = 0;

        for(int i=0; i<=N; i++){
            for(int j=0; j<=N; j++){
                //한국이
                if(i < N) {
                    if (!korea[i + 1]) {
                        dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j]);
                    } else {
                        dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + p1);
                        for(int k=1; k<=3; k++){
                            dp[Math.min(N, i + k)][j] = Math.min(dp[Math.min(N, i + k)][j], dp[i][j] + p3);
                        }
                        for(int k=1; k<=5; k++){
                            dp[Math.min(N, i + k)][j] = Math.min(dp[Math.min(N, i + k)][j], dp[i][j] + p5);
                        }
                    }
                }

                //정올이
                if(j < N) {
                    if (!all[j + 1]) {
                        dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j]);
                    } else {
                        dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + p1);
                        for(int k=1; k<=3; k++){
                            dp[i][Math.min(N, j + k)] = Math.min(dp[i][Math.min(N, j + k)], dp[i][j] + p3);
                        }
                        for(int k=1; k<=5; k++){
                            dp[i][Math.min(N, j + k)] = Math.min(dp[i][Math.min(N, j + k)], dp[i][j] + p5);
                        }
                    }
                }

                //pair권
                if(i==j && i<N && j<N){
                    for(int a=1; a<=4; a++){
                        for(int b=1; b<=4; b++){
                            dp[Math.min(N,i+a)][Math.min(N,j+b)] =
                                    Math.min(dp[Math.min(N,i+a)][Math.min(N,j+b)], dp[i][j]+pp);
                        }
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));

        System.out.println(dp[N][N]);
    }
}
