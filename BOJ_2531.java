import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2531 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] dishes = new int[N];
        for(int i=0; i<N; i++){
            dishes[i] = Integer.parseInt(br.readLine());
        }

        int[] counts = new int[d+1];
        counts[c] = 1;

        int num = 1;
        // 초기값
        for(int j=0; j<k; j++) {
            if (++counts[dishes[j]]==1) num++;
        }
        int max = num;

        for(int i=1; i<N; i++){
            //맨 앞 제거
            if(--counts[dishes[i-1]]==0) num--;

            //맨 뒤 추가
            if (++counts[dishes[(i+k-1)%N]]==1) num++;

            System.out.println(i+"번째 "+num + " " + Arrays.toString(counts));
            max = Math.max(max, num);
        }
        System.out.println(max);
    }
}
