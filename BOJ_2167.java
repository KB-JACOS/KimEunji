import java.io.*;
import java.util.*;

public class BOJ_2167 {
    static int[][] arr;
    static int[][] prefix;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n+1][m+1];
        prefix = new int[n+1][m+1];

        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=m;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //누적합 배열
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                prefix[i][j] = prefix[i-1][j] +  prefix[i][j-1] - prefix[i-1][j-1] + arr[i][j];
            }
        }

        int k = Integer.parseInt(br.readLine());
        for(int i=0;i<k;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            int result = prefix[c][d] - prefix[c][b-1] - prefix[a-1][d] + prefix[a-1][b-1];
            System.out.println(result);
        }
    }
}
