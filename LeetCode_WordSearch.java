class LeetCode_WordSearch {
    static int rowSize, colSize;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    public boolean exist(char[][] board, String word) {
        rowSize = board.length;
        colSize = board[0].length;

        for(int i=0; i<rowSize; i++){
            for(int j=0; j<colSize; j++){
                if(board[i][j] == word.charAt(0)){
                    boolean[][] visited = new boolean[rowSize][colSize];
                    visited[i][j] = true;
                    if(dfs(i, j, 1, board, word, visited)) return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int startR, int startC, int idx, char[][] board, String word, boolean[][] visited){
        if(idx == word.length()){
            return true;
        }

        for(int i=0; i<4; i++){
            int nextR = startR + dr[i], nextC = startC + dc[i];
            if(isInBound(nextR, nextC) && !visited[nextR][nextC] && board[nextR][nextC] == word.charAt(idx)){
                visited[nextR][nextC] = true;
                if(dfs(nextR, nextC, idx+1, board, word, visited)) return true;
                visited[nextR][nextC] = false;
            }
        }
        return false;
    }

    private boolean isInBound(int nextR, int nextC){
        return 0<=nextR && nextR < rowSize && 0<=nextC && nextC < colSize;
    }
}