import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_22251 {
    static int[] led = {
            0b1111110, //0
            0b0000110, //1
            0b1011011, //2
            0b1001111, //3
            0b0100111, //4
            0b1101101, //5
            0b1111101, //6
            0b1000110, //7
            0b1111111, //8
            0b1101111  //9
    };
    static int[][] diff = new int[10][10];

    static int N, K, P, X;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //1부터 n까지
        K = Integer.parseInt(st.nextToken()); //자릿수
        P = Integer.parseInt(st.nextToken()); //최대 반전 수
        X = Integer.parseInt(st.nextToken()); //현재 층

        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                diff[i][j] = Integer.bitCount(led[i]^led[j]);
            }
        }

        String curFloor = changeFloor(X);

        int result = 0;
        for(int i=1; i<=N; i++){
            if(i == X) continue;

            String iFloor = changeFloor(i);

            int change = 0;
            for(int j=0; j<K; j++){
                change += diff[iFloor.charAt(j)-'0'][curFloor.charAt(j)-'0'];
                if(change > P) break;
            }

            if(change > 0 && change <= P) result ++;
        }
        System.out.println(result);
    }

    //자릿수 보정
    private static String changeFloor(int x){
        String floor = Integer.toString(x);
        while(floor.length() < K){
            floor = "0" + floor;
        }
        return floor;
    }
}
