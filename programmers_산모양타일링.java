//[참고] https://tolerblanc.github.io/programmers/programmers-mountain-tiling/
class Solution {
    public int solution(int n, int[] tops) {
        int answer = 0;
        int[] dp1 = new int[n+1];
        int[] dp2 = new int[n+1];
        
        dp1[1] = 1; 
        dp2[1] = tops[0] + 2;
        
        for(int i=2; i<=n; i++){
            // %10007 : 계산 중간 오버플로 방지
            dp1[i] = (dp1[i-1] + dp2[i-1]) % 10007;
            dp2[i] = (dp1[i-1]*(tops[i-1]+1) + dp2[i-1]*(tops[i-1]+2)) % 10007;
        }
        
        return (int)((dp1[n]+dp2[n])%10007);
    }
}
