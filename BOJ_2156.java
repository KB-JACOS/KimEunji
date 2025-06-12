import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];
        for(int i=0;i<N;i++) {
            array[i] = Integer.parseInt(br.readLine());
        }
        //dp
        int[][] dpArray = new int[N][3];
        dpArray[0][1] = array[0];
        for(int i=1;i<N;i++) {
            dpArray[i][0] = Math.max(dpArray[i-1][0], Math.max(dpArray[i-1][1], dpArray[i-1][2]));
            dpArray[i][1] = dpArray[i-1][0] + array[i];
            dpArray[i][2] = dpArray[i-1][1] + array[i];
        }

        System.out.println(Math.max(dpArray[N-1][0],  Math.max(dpArray[N-1][1], dpArray[N-1][2])));
    }
}
