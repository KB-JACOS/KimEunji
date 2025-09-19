import java.util.*;
import java.io.*;

class programmers_경주로건설 {
    int[] dr = new int[]{-1, 1, 0, 0};
    int[] dc = new int[]{0, 0, -1, 1};
    // 0,1 -> 가로 / 2,3 -> 세로

    int rowSize, colSize;
    int[][][] memo;
    int answer = Integer.MAX_VALUE;

    public int solution(int[][] board) {
        rowSize = board.length;
        colSize = board[0].length;
        memo = new int[rowSize][colSize][2];

        for(int i=0; i<rowSize; i++){
            for(int j=0; j<colSize; j++){
                for(int k=0; k<2; k++){
                    memo[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }

        bfs(board);

        // for(int[][] mem : memo){
        //     for(int[] me : mem){
        //         System.out.println(Arrays.toString(me));
        //     }
        // }

        return answer;
    }

    private void bfs(int[][] board){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0, 0, -1}); //시작값

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curR = cur[0], curC = cur[1], curCost = cur[2], curDir = cur[3];

            if(curR == rowSize-1 && curC == colSize-1){
                answer = Math.min(answer, curCost);
                continue;
            }

            for(int i=0; i<4; i++){
                int nextR = curR + dr[i], nextC = curC + dc[i];
                if(!inBound(nextR, nextC) || board[nextR][nextC] == 1) continue;


                //직선
                if(curDir == -1 || (curDir / 2 == i / 2)){
                    int tmpCost = curCost + 100;
                    if(memo[nextR][nextC][0] >= tmpCost){
                        memo[nextR][nextC][0] = tmpCost;
                        q.offer(new int[]{nextR, nextC, memo[nextR][nextC][0], i});
                    }
                }

                //수직
                else{
                    int tmpCost = curCost + 600;
                    if(memo[nextR][nextC][1] >= tmpCost){
                        memo[nextR][nextC][1] = tmpCost;
                        q.offer(new int[]{nextR, nextC, memo[nextR][nextC][1], i});
                    }
                }
            }
        }
    }

    private boolean inBound(int r, int c){
        return 0<=r && r<rowSize && 0<=c && c<colSize;
    }
}