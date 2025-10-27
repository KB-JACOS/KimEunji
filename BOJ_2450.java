import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2450 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] board = new int[N];
        int[] num = new int[4]; // 개수

        for(int i=0; i<N; i++){
            board[i] = Integer.parseInt(st.nextToken());
            num[board[i]]++;
        }

        int result = Integer.MAX_VALUE;
        int[][] perm = {{1,2,3}, {1,3,2}, {2,1,3}, {2,3,1}, {3,1,2}, {3,2,1}};
        for(int i=0; i<6; i++){
            int[][] diff = new int[4][4];
            int[] curPerm = perm[i];

            int idx = 0;
            for(int j=0; j<num[curPerm[0]]; j++){
                diff[curPerm[0]][board[idx]] ++;
                idx++;
            }
            for(int j=0; j<num[curPerm[1]]; j++){
                diff[curPerm[1]][board[idx]] ++;
                idx++;
            }
            for(int j=0; j<num[curPerm[2]]; j++){
                diff[curPerm[2]][board[idx]] ++;
                idx++;
            }

            result = Math.min(result, diff[curPerm[0]][curPerm[1]] + diff[curPerm[0]][curPerm[2]]
                    + Math.max(diff[curPerm[1]][curPerm[2]],  diff[curPerm[2]][curPerm[1]]));
        }

        System.out.println(result);
    }
}