import java.util.*;
class Solution {
    static int[] dr = {1, 0, 0, -1};
    static int[] dc = {0, -1, 1, 0};
    static char[] letter = {'d', 'l', 'r', 'u'};
    
    static String answer = "";
    static int n, m, r, c, k;
    static boolean isReachable = false;
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) { 
        this.n = n;
        this.m = m;
        this.r = r;
        this.c = c;
        this.k = k;
        
        bt(x, y, new StringBuilder(), 0);
        if(answer.equals("")) return "impossible";
        else return answer;
    }
    
    public void bt(int curR, int curC, StringBuilder str, int depth){
        if(curR == r && curC == c && depth == k ){
            isReachable = true;
            answer = str.toString();
            return;
        }
        
        int dist = Math.abs(curR - r) + Math.abs(curC - c);
        if(depth + dist > k || (k - (depth + dist))%2 == 1 || isReachable) return;
        
        
        for(int i=0; i<4; i++){
            int nextR = curR + dr[i];
            int nextC = curC + dc[i];
            char nextLetter = letter[i];
            
            if(canReach(nextR, nextC)){
                str.append(nextLetter);
                bt(nextR, nextC, str, depth+1);
                str.deleteCharAt(str.length()-1);
            }
        }
    }
    
    private boolean canReach(int row, int col){
        return 1<=row && row<=n && 1<=col && col<=m;
    }
}