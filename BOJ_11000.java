import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Queue<int[]> reqQ = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            reqQ.offer(new int[]{s, e});
        }

        Queue<Integer> resQ = new PriorityQueue<>((a,b) -> a - b);
        while(!reqQ.isEmpty()){
            int[] cur = reqQ.poll();
            if(resQ.isEmpty() || cur[0] >= resQ.peek()) resQ.poll(); //공집합 없음
            resQ.offer(cur[1]);
        }
        System.out.println(resQ.size());
    }
}
