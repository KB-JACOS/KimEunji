import java.util.*;
import java.io.*;

public class BOJ_2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] request = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            request[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine()); //총 예산

        Arrays.sort(request);

        int answer = 0;
        int left = 1, right = request[N-1];
        while(left<=right){
            int mid = (left + right)/2; //상한액

            int sum = 0;
            for(int req : request){
                sum += Math.min(mid, req);
            }

            if(sum <= M){
                left = mid+1;
                answer = mid;
            } else {
                right = mid-1;
            }
        }
        System.out.println(answer);
    }
}
