import java.util.*;
import java.io.*;

public class BOJ_2096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] num = new int[N+1][3];
        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                num[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] min = new int[N+1][3];
        int[][] max = new int[N+1][3];

        for(int i=1; i<=N; i++){
            min[i][0] = num[i][0] + Math.min(min[i-1][0], min[i-1][1]);
            min[i][1] = num[i][1] + Math.min(min[i-1][0], Math.min(min[i-1][1], min[i-1][2]));
            min[i][2] = num[i][2] + Math.min(min[i-1][1], min[i-1][2]);
        }

        for(int i=1; i<=N; i++){
            max[i][0] = num[i][0] + Math.max(max[i-1][0], max[i-1][1]);
            max[i][1] = num[i][1] + Math.max(max[i-1][0], Math.max(max[i-1][1], max[i-1][2]));
            max[i][2] = num[i][2] + Math.max(max[i-1][1], max[i-1][2]);
        }

        System.out.print(Math.max(max[N][0], Math.max(max[N][1], max[N][2])));
        System.out.print(" ");
        System.out.println(Math.min(min[N][0], Math.min(min[N][1], min[N][2])));
    }
}
