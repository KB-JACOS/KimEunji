import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] array = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = 0;
        int min = M+1;
        int sum = array[start];
        while(start <= end){
            System.out.println("idx : " + start + " " + end);
            System.out.println("sum : " + sum);
            if(sum < N && end < M-1) {
                end ++;
                sum += array[end];
            }
            else if(sum >= N || end == M-1) {
                if(sum >= N) min = Math.min(min, end - start + 1);
                sum -= array[start];
                start ++;
                System.out.println("min : " + min);
            }
        }
        if(min == M+1) min = 0;
        System.out.println(min);
    }
}
