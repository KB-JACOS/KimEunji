import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2473_Copy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] num = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) num[i] = Long.parseLong(st.nextToken());
        Arrays.sort(num);

        int leftIdx = 1, rightIdx = N-1;
        long totalTmp = Long.MAX_VALUE;
        int idx = 0;

        for(int i=0; i<N-2; i++){
            int left = i + 1, right = N-1;
            while(left<right){
                long tmp = num[left] + num[right] + num[i];
                if(Math.abs(totalTmp) > Math.abs(tmp)){
                        totalTmp = tmp;
                        idx = i;
                        leftIdx = left;
                        rightIdx = right;
                }

                if(tmp>0) right--;
                else left++;
            }
        }

        System.out.println(num[idx]);
        System.out.println(num[leftIdx]);
        System.out.println(num[rightIdx]);
    }
}
