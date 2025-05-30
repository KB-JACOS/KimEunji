import java.util.*;

class programmers_거리두기확인하기 {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static char[][] maps;
    static boolean[][] visited;
    static int[] answer = new int[5];

    public int[] solution(String[][] places) {
        for (int i = 0; i < 5; i++) { //반복
            maps = new char[5][5];
            List<int[]> cand = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    maps[j][k] = places[i][j].charAt(k);
                    if (maps[j][k] == 'P') {
                        cand.add(new int[]{j, k});
                    }
                }
            }
            answer[i] = checkDist(cand);
        }
        return answer;
    }

    private int checkDist(List<int[]> cand) {
        for (int i = 0; i < cand.size(); i++) {
            int[] curCand = cand.get(i);
            visited = new boolean[5][5];
            if (!bfs(curCand[0], curCand[1])) return 0;
        }
        return 1;
    }

    private boolean bfs(int r, int c) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{r, c, 1});
        visited[r][c] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nextR = cur[0] + dr[i], nextC = cur[1] + dc[i];
                if (isInBound(nextR, nextC) && !visited[nextR][nextC]) {
                    if (maps[nextR][nextC] == 'P') {
                        return false;
                    } else if (maps[nextR][nextC] == 'O' && cur[2] == 1) {
                        q.offer(new int[]{nextR, nextC, cur[2] + 1});
                        visited[nextR][nextC] = true;
                    }
                }
            }
        }
        return true;
    }

    private boolean isInBound(int r, int c) {
        return 0 <= r && r < 5 && 0 <= c && c < 5;
    }
}