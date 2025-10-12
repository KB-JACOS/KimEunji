import java.util.*;
class programmers_사라지는발판 {
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, 1, -1};

    int[][] board;
    public int solution(int[][] board1, int[] aloc, int[] bloc) {
        board = board1;
        return bt(aloc[0], aloc[1], bloc[0], bloc[1]);
    }

    private int bt(int curR, int curC, int tmpCurR, int tmpCurC){
        if(board[curR][curC] == 0) return 0;

        int ret = 0;

        for(int i=0; i<4; i++){
            int nextR = curR + dr[i], nextC = curC + dc[i];
            if(!isInBound(nextR, nextC) || board[nextR][nextC] == 0) continue;

            board[curR][curC] = 0;
            int cnt = bt(tmpCurR, tmpCurC, nextR, nextC) + 1;
            board[curR][curC] = 1;

            if(ret % 2 == 0){
                if(cnt % 2 == 0){
                    ret = Math.max(cnt, ret);
                } else {
                    ret = cnt;
                }
            } else {
                if(cnt % 2 == 1){
                    ret = Math.min(cnt, ret);
                }
            }
        }
        return ret;
    }

    private boolean isInBound(int r, int c){
        return 0<=r && r< board.length && 0<=c && c< board[0].length;
    }
}