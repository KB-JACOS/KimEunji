import java.util.*;

class programmers_전력망을둘로나누기 {
    static List<List<Integer>> tree;

    public static void main(String[] args) {
        int answer = solution(9, new int[][]{
                {1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}
        });
        System.out.println(answer);
    }

    public static int bfs(int i) {
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[101];

        q.offer(i);
        visited[i] = true;

        int popCnt = 0;
        while (!q.isEmpty()) {
            int pop = q.poll();
            popCnt++;
            for (int j = 0; j < tree.get(pop).size(); j++) {
                int tmp = tree.get(pop).get(j);
                if (!visited[tmp]) {
                    q.offer(tmp);
                    visited[tmp] = true;
                }
            }
        }
        return popCnt;
    }

    public static int solution(int n, int[][] wires) {
        tree = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < wires.length; i++) {
            tree.get(wires[i][0]).add(wires[i][1]);
            tree.get(wires[i][1]).add(wires[i][0]);
        }

        int min = 100;
        for (int idx = 1; idx < n + 1; idx++) {
            for (int i = 0; i < tree.get(idx).size(); i++) {
                int tmp = tree.get(idx).get(i);
                int index = tree.get(tmp).indexOf(idx);

                tree.get(idx).remove(Integer.valueOf(tmp));
                tree.get(tmp).remove(Integer.valueOf(idx));

                min = Math.min(min, Math.abs(n - 2 * bfs(idx)));

                tree.get(idx).add(i, tmp);
                tree.get(tmp).add(index, idx);
            }
        }
        return min;
    }
}