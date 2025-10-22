import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14888 {
    static int N;
    static int[] number, oper;

    static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // input
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        number = new int[N];
        for(int i=0; i<N; i++) number[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        oper = new int[4];
        for(int i=0; i<4; i++) oper[i] = Integer.parseInt(st.nextToken());

        // logic
        bt(number[0], 1);

        // output
        System.out.println(max);
        System.out.println(min);
    }

    private static void bt(int sum, int idx){
        if(idx >= N) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }

        for(int i=0; i<4; i++){
            if(oper[i] > 0){
                oper[i]--;

                if(i == 0) bt(sum + number[idx], idx+1);
                else if(i == 1) bt(sum - number[idx], idx+1);
                else if(i == 2) bt(sum * number[idx], idx+1);
                else bt(sum / number[idx], idx+1);

                oper[i]++;
            }
        }
    }
}
