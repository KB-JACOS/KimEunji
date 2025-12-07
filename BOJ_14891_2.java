import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14891_2 {
    static int[][] wheels;
    static int[] rPoints;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        wheels = new int[4][8];
        for(int i=0; i<4; i++){
            String str = br.readLine();
            for(int j=0; j<8; j++){
                wheels[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }
        rPoints = new int[4];
        for(int i=0; i<4; i++) rPoints[i] = 2;

        int K = Integer.parseInt(br.readLine());
        for(int i=0; i<K; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken())-1;
            int dir = - Integer.parseInt(st.nextToken());

            // 방향 같은지 미리 확인
            boolean[] check = new boolean[3];
            for(int j=0; j<3; j++) check[j] = checkSame(j);

            rPoints[num] = (rPoints[num] + dir);

            // 왼쪽 전파
            int n = num, d = dir;
            while(n > 0){
                if(!check[n-1]){
                    rPoints[n-1] = (rPoints[n-1] - d);
                    d = - d;
                    n--;
                }
                else break;
            }

            // 오른쪽 전파
            n = num;  d = dir;
            while(n < 3){
                if(!check[n]){
                    rPoints[n+1] = (rPoints[n+1] - d);
                    d = - d;
                    n++;
                }
                else break;

            }

            for(int j=0; j<4; j++){
                rPoints[j] = (rPoints[j] % 8 + 8) % 8;
            }
            System.out.println(Arrays.toString(rPoints));
        }

        // 점수 계산
        int score = 0;
        for(int i=0, mul = 1; i<4; i++, mul *= 2){
            if(rPoints[i]-2 < 0) rPoints[i] = 8 + rPoints[i];

            score += wheels[i][rPoints[i]-2] * mul;
        }
        System.out.println(score);
    }
    private static boolean checkSame(int n){
        return wheels[n][rPoints[n]] == wheels[n+1][(rPoints[n+1]+4)%8];
    }
}
