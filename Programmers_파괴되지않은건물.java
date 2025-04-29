class Programmers_파괴되지않은건물 {
    public int solution(int[][] board, int[][] skill) {
        int[][] initial = new int[board.length + 1][board[0].length + 1];
        int[][] prefix = new int[board.length + 1][board[0].length + 1];

        //initial array
        for (int i = 0; i < skill.length; i++) {
            int a = skill[i][1];
            int b = skill[i][2];
            int x = skill[i][3];
            int y = skill[i][4];
            int degree = skill[i][5];

            if (skill[i][0] == 1) {
                degree = -degree;
            }

            initial[a][b] += degree;
            initial[x + 1][b] -= degree;
            initial[a][y + 1] -= degree;
            initial[x + 1][y + 1] += degree;
        }

        //prefix sum array
        for (int i = 1; i < prefix.length; i++) {
            for (int j = 1; j < prefix[0].length; j++) {
                prefix[i][j] = prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1] + initial[i-1][j-1];
            }
        }

        //board + prefix sum
        int answer = 0;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                board[i][j] += prefix[i+1][j+1];
                if(board[i][j] > 0){
                    answer ++;
                }
            }
        }
        return answer;
    }
}
