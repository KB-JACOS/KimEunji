import java.util.*;
import java.io.*;

public class BOJ_11003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] num = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        Deque<int[]> q = new ArrayDeque<>(); //idx, 값 저장

        int right = 0;
        while(right<N){
            // 내가 맨 마지막 값이 되도록 offer
            while(true){
                if(q.isEmpty() || q.peekLast()[1]<num[right]){
                        q.offer(new int[]{right, num[right]});
                        break;
                } else {
                        q.pollLast();
                }
            }

            //맨 앞 값이 범위를 벗어나는지 확인
            if(q.peek()[0]<right-L+1) q.poll();

            //맨 앞 값(최소값) print
            sb.append(q.peek()[1]).append(" ");

            //다음 윈도우로
            right++;
        }

        System.out.println(sb);
    }
}
