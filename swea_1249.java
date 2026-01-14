import java.io.*;
import java.util.*;

public class swea_1249 {
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());

        int tc = 1;
        while(testcase-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[][] nums = new int[N][N];
            int[][] nums2 = new int[N][N];

            for(int i = 0; i < N; i++) {
                String st = br.readLine();
                for(int j = 0; j < N; j++) {
                    nums[i][j] = st.charAt(j) - '0';
                    nums2[i][j] = Integer.MAX_VALUE;
                }
            }

            Queue<int[]> q = new PriorityQueue<>((a,b) -> a[2] - b[2]);
            q.offer(new int[] {0, 0, nums[0][0]});
            while(!q.isEmpty()) {
                int[] cur = q.poll();
                int r = cur[0], c = cur[1], d = cur[2];

                if(nums2[r][c] < d) continue;

                for(int i = 0; i < 4; i++) {
                    int nr = r + dr[i], nc = c + dc[i];
                    if(nr >= 0 && nr < N && nc >= 0 && nc < N
                            && nums2[nr][nc] > d+nums[nr][nc]
                    ) {
                        q.offer(new int[] {nr, nc, d+nums[nr][nc]});
                        nums2[nr][nc] = d+nums[nr][nc];
                    }
                }
            }
            //System.out.println(Arrays.deepToString(nums2));
            System.out.println("#" + tc++ +" "+nums2[N-1][N-1]);
        }
    }
}
