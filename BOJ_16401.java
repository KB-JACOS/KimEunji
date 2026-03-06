import java.util.*;
import java.io.*;

public class BOJ_16401 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()); // 조카의 수
        int N = Integer.parseInt(st.nextToken()); // 과자의 수

        int[] length = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            length[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(length);
        int answer = -1;
        int left = 1, right = length[N-1];
        while(left <= right){
            int mid = (left + right) / 2;
            int count = 0;
            for(int i=0; i<N; i++){
                count += length[i]/mid;
            }

            // System.out.println("mid = " + mid + " count = " + count);
            if(count < M){
                right = mid-1;
            } else if(count >= M){
                answer = mid;
                left = mid+1;
            }
        }

        if(answer==-1) System.out.println(0);
        else System.out.println(answer);
    }
}
