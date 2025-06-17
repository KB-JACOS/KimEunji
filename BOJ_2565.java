import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            List<Integer> curList = new ArrayList<>();
            curList.add(x); curList.add(y);
            list.add(curList);
        }

        Collections.sort(list, (a, b) -> a.get(0) - b.get(0) );
        //System.out.println(list);

        int[] dp = new int[n];
        Arrays.fill(dp,1);

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){ //현재
            for(int j = 0; j < i; j++){ //자기 앞
                if(list.get(i).get(1) > list.get(j).get(1)){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
                max = Math.max(max, dp[i]);
            }
        }
        //System.out.println(Arrays.toString(dp));
        System.out.println(list.size() - max);
    }
}
