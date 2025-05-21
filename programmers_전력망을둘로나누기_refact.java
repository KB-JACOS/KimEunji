import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class programmers_전력망을둘로나누기_refact {

    public static void main(String[] args) {
        int answer = solution(9, new int[][]{
                {1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}
        });
        System.out.println(answer);
    }

    public static int bfs(List<List<Integer>> graph, int n) {
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];

        q.offer(1);
        visited[1] = true;

        int popCnt = 0;
        while (!q.isEmpty()) {
            int pop = q.poll();
            popCnt++;
            for (int j = 0; j < graph.get(pop).size(); j++) {
                int tmp = graph.get(pop).get(j);
                if (!visited[tmp]) {
                    q.offer(tmp);
                    visited[tmp] = true;
                }
            }
        }
        return popCnt;
    }

    public static List<List<Integer>> drawGraph(int n, int[][] wires, int a, int b) {
        List<List<Integer>> tmpGraph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            tmpGraph.add(new ArrayList<>());
        }

        for (int[] wire : wires) {
            if (wire[0] == a && wire[1] == b) continue;
            tmpGraph.get(wire[0]).add(wire[1]);
            tmpGraph.get(wire[1]).add(wire[0]);

        }
        return tmpGraph;
    }

    public static int solution(int n, int[][] wires) {
        int min = Integer.MAX_VALUE;
        for (int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];
            List<List<Integer>> graph = drawGraph(n, wires, a, b);
            min = Math.min(min, Math.abs(n - 2 * bfs(graph, n)));
        }

        return min;
    }
}