import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] rain = new int[W];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<W; i++) rain[i] = Integer.parseInt(st.nextToken());

        int count = 0;
        for(int i=0; i<W; i++) {
            //왼
            int maxLeft = 0, maxRight = 0;
            for(int j=i-1; j>=0; j--) maxLeft = Math.max(rain[j], maxLeft);

            //오
            for(int j=i+1; j<W; j++) maxRight = Math.max(rain[j], maxRight);

            int min = Math.min(maxLeft, maxRight);

            if(min <= rain[i]) continue;
            count += (min-rain[i]);
        }
        System.out.println(count);
    }
}
