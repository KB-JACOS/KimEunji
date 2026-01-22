import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2548 {
    //누적합 계산으로 값 비교
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        int[] sums = new int[N]; sums[0] = nums[0];
        for(int i=1; i<N; i++){
            sums[i] = sums[i-1] + nums[i];
        }

        int min = Integer.MAX_VALUE, minIdx = 0;
        for(int i=0; i<N; i++){
           int rightSum = sums[N-1] - sums[i];
           int leftSum = (i==0)? 0 : sums[i-1];

           int sum = nums[i]*i - leftSum + rightSum - nums[i]*(N-1-i);
           if(min > sum){
               min = sum;
               minIdx = i;
           }
        }
        System.out.println(nums[minIdx]);
    }
}
