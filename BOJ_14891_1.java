import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14891_1 {
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
        for(int i=0; i<4; i++){
            rPoints[i] = 2;
        }

        int K = Integer.parseInt(br.readLine());
        for(int i=0; i<K; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken())-1;
            int dir = - Integer.parseInt(st.nextToken());

            if(num == 0){
                if(!checkSame(0)){
                    if(!checkSame(1)){
                        if(!checkSame(2)){
                            rPoints[3] = (rPoints[3] - dir);
                        }
                        rPoints[2] = (rPoints[2] + dir);
                    }
                    rPoints[1] = (rPoints[1] - dir);
                }
                rPoints[0] = (rPoints[0] + dir);
            }
            else if(num == 1){
                if(!checkSame(1)){
                    if(!checkSame(2)){
                        rPoints[3] = (rPoints[3] + dir);
                    }
                    rPoints[2] = (rPoints[2] - dir);
                }
                if(!checkSame(0)){
                    rPoints[0] = (rPoints[0] - dir);
                }
                rPoints[1] = (rPoints[1] + dir);
            }
            else if(num == 2){
                if(!checkSame(2)){
                    rPoints[3] = (rPoints[3] - dir);
                }
                if(!checkSame(1)){
                    if(!checkSame(0)){
                        rPoints[0] = (rPoints[0] + dir);
                    }
                    rPoints[1] = (rPoints[1] - dir);
                }
                rPoints[2] = (rPoints[2] + dir);
            }
            else {
                if(!checkSame(2)){
                    if(!checkSame(1)){
                        if(!checkSame(0)){
                            rPoints[0] = (rPoints[0] - dir);
                        }
                        rPoints[1] = (rPoints[1] + dir);
                    }
                    rPoints[2] = (rPoints[2] - dir);
                }
                rPoints[3] = (rPoints[3] + dir);
            }

            for(int j=0; j<4; j++){
                if(rPoints[j] < 0) rPoints[j] = 8 + rPoints[j];
                else rPoints[j] = (rPoints[j]) % 8;
            }
            System.out.println(Arrays.toString(rPoints));
        }
        int score = 0;
        for(int i=0, mul = 1; i<4; i++){
            if(rPoints[i]-2 < 0) rPoints[i] = 8 + rPoints[i];
            score += wheels[i][rPoints[i]-2] * mul;
            mul *= 2;
        }
        System.out.println(score);
    }
    private static boolean checkSame(int n){
        return wheels[n][rPoints[n]] == wheels[n+1][(rPoints[n+1]+4)%8];
    }
}