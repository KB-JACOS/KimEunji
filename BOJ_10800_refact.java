import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_10800_refact {
    public static class Ball {
        int idx, color, size, result;

        Ball(int idx, int color, int size){
            this.idx = idx;
            this.color = color;
            this.size = size;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        List<Ball> balls = new ArrayList<>();
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            balls.add(new Ball(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(balls, (a,b)->{
            if(a.size == b.size) return a.color-b.color;
            return a.size - b.size;
        });

        int[] sum = new int[N+1];
        int[] colorSum = new int[N+1];
        int[] sizeSum = new int[2001];

        // 0
        Ball ball0 = balls.get(0);
        colorSum[ball0.color] = ball0.size;
        sizeSum[ball0.size] ++;

        // 1 ~ N
        for(int i=1; i<N; i++){
            Ball cur = balls.get(i), prev = balls.get(i-1);
            sum[i] = sum[i-1] + prev.size;

            // result 계산
            if(prev.size == cur.size && prev.color == cur.color) cur.result = prev.result;
            else cur.result = sum[i] - colorSum[cur.color] - sizeSum[cur.size] * cur.size;

            // 이후 작업
            colorSum[cur.color] += cur.size;
            sizeSum[cur.size] ++;
        }

        // 출력
        Collections.sort(balls, (a,b)-> a.idx - b.idx);
        for(Ball ball : balls) sb.append(ball.result).append("\n");

        System.out.println(sb);
    }
}