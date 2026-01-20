import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2632 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int buy = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] a = new int[m];
        int[] b = new int[n];

        for(int i=0; i<m; i++){
            a[i] = Integer.parseInt(br.readLine());
        }
        for(int i=0; i<n; i++){
            b[i] = Integer.parseInt(br.readLine());
        }

        int[][] aSum = new int[m][m];
        int[][] bSum = new int[n][n];

        for(int i=0; i<m; i++){
            for(int j=i; j<i+m; j++){
                if(j==0) aSum[i][0] = a[i];
                else aSum[i][j%m] = aSum[i][(j-1)%m] + a[j%m];
            }
        }

        for(int i=0; i<n; i++){
            for(int j=i; j<i+n; j++){
                if(j==0) bSum[i][0] = b[i];
                else bSum[i][j%n] = bSum[i][(j-1)%n] + b[j%n];
            }
        }

        int[] aSize = new int[buy+1], bSize = new int[buy+1];
        aSize[0] =1; bSize[0] = 1;
        if(buy >= aSum[0][m-1]) aSize[aSum[0][m-1]] -= m-1;
        if(buy >= bSum[0][n-1]) bSize[bSum[0][n-1]] -= n-1;
        for(int i=0; i<m; i++) {
            for (int j = 0; j < m; j++) {
                int tmp = aSum[i][j];
                if (buy >= tmp && tmp >= 0) {
                    aSize[tmp]++;
                }
            }
        }
        for(int i=0; i<n; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = bSum[i][j];
                if (buy >= tmp && tmp >= 0) {
                    bSize[tmp]++;
                }
            }
        }

        int count = 0;
        for(int i=0; i<buy+1; i++){
            count += aSize[i] * bSize[buy-i];
        }
        System.out.println(count);
    }
}
