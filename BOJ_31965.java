import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_31965 {
    static long[] nums, sums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        nums = new long[N+1]; sums = new long[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            nums[i] = Long.parseLong(st.nextToken());
            sums[i] = nums[i] + sums[i-1];
        }

        for(int i=0; i<Q; i++){
            st = new StringTokenizer(br.readLine());
            long start = Long.parseLong(st.nextToken()), end = Long.parseLong(st.nextToken());
            int startIdx = findStartIdx(start), endIdx = findEndIdx(end);

            // 회의 세트에 참여하는 사람이 1명 이하 - 피로도 0
            if(startIdx >= endIdx){
                sb.append(0).append("\n");
                continue;
            }

            long startSum = calcSum(startIdx, startIdx, endIdx);
            long endSum = calcSum(endIdx, startIdx, endIdx);
            long medianSum = calcSum((startIdx+endIdx)/2, startIdx, endIdx);

//            System.out.println(startSum + " " + endSum + " " + medianSum);
            sb.append(Math.max(startSum, endSum)-medianSum).append("\n");
        }
        System.out.println(sb);
    }

    // 이진탐색 log(n)
    // start보다 크거나 같은 최소값 idx
    private static int findStartIdx(long start){
        int left = 1, right = nums.length-1, mid;
        int tmp = right;

        while(left <= right){
            mid = (left + right) / 2;
            if(nums[mid] >= start){
                tmp = Math.min(mid, tmp);
                right = mid-1;
            } else if(nums[mid] < start){
                left = mid+1;
            }
        }
        return tmp;
    }

    // end보다 작거나 같은 최대값 idx
    private static int findEndIdx(long end){
        int left = 1, right = nums.length-1, mid;
        int tmp = left;

        while(left <= right){
            mid = (left + right) / 2;
            if(nums[mid] <= end){
                tmp = Math.max(mid, tmp);
                left = mid+1;
            } else if(nums[mid] > end){
                right = mid-1;
            }
        }
        return tmp;
    }

    private static long calcSum(int target, int startIdx, int endIdx){
        long rightSum = (sums[endIdx] - sums[target-1]) - nums[target] * (endIdx - target+1);
        long leftSum = nums[target] * (target - startIdx+1) - (sums[target] - sums[startIdx-1]);
//        System.out.println(leftSum + " " + rightSum);
        return leftSum + rightSum;
    }
}
