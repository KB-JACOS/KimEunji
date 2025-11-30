import java.util.*;

// 팀장 O, 팀원 X
// 팀장 O, 팀원 O
// 팀장 X, 팀원 O
// 팀장 X, 팀원 X -> 다른 팀원이 O
class programmers_매출하락최소화 {
    List<List<Integer>> list = new ArrayList<>();
    int[][] dp;
    public int solution(int[] sales, int[][] links) {
        int answer = 0;

        dp = new int[sales.length+1][2]; //0 : 불참, 1 : 참석

        for(int i=0; i<=sales.length; i++) list.add(new ArrayList<>());
        for(int i=0; i<sales.length; i++) dp[i+1][1] = sales[i];

        for(int[] link : links) list.get(link[0]).add(link[1]);

        dfs(1);

        return Math.min(dp[1][0], dp[1][1]);
    }

    private void dfs(int cur){
        //리프노드면 반환
        if(list.get(cur).size() == 0) return;

        int extra = Integer.MAX_VALUE;

        for(int l : list.get(cur)){
            dfs(l);
            //팀원 X
            if(dp[l][0] < dp[l][1]){
                dp[cur][1] += dp[l][0];
                dp[cur][0] += dp[l][0]; // 다른 팀원이 참여해야함
                extra = Math.min(extra, dp[l][1] - dp[l][0]);
            }
            //팀원 O
            else{
                dp[cur][1] += dp[l][1];
                dp[cur][0] += dp[l][1];
                extra = 0;
            }
        }
        dp[cur][0] += extra; // cur 불참 시 반드시 한 명은 참석해야 함
    }
}
