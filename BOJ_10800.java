import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_10800 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        List<int[]> balls = new ArrayList<>();
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            //balls : 인덱스, 컬러, 사이즈, 값
            balls.add(new int[]{i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0});
        }

        Collections.sort(balls, (a,b)->{
            if(a[2]==b[2]){
                return a[1]-b[1];
            }
            return a[2]-b[2];
        });

        int[] sum = new int[N+1], colorSum = new int[N+1];
        int[] sizeSum = new int[2001];

        // 0
        colorSum[balls.get(0)[1]] = balls.get(0)[2];
        sizeSum[balls.get(0)[2]] ++;

        // 1 ~ N
        for(int i=1; i<N; i++){
            sum[i] = sum[i-1] + balls.get(i-1)[2];

            //계산
            if(balls.get(i-1)[2] == balls.get(i)[2] && balls.get(i-1)[1] == balls.get(i)[1]){
                balls.get(i)[3] = balls.get(i-1)[3];
            } else balls.get(i)[3] = sum[i] - colorSum[balls.get(i)[1]] - sizeSum[balls.get(i)[2]] * balls.get(i)[2];

            //이후 작업
            colorSum[balls.get(i)[1]] += balls.get(i)[2];
            sizeSum[balls.get(i)[2]] ++;
        }

        // 출력
        Collections.sort(balls, (a,b)-> a[0] - b[0]);
        for(int[] ball : balls) sb.append(ball[3]).append("\n");

        System.out.println(sb);
    }
}