import java.io.*;
import java.util.*;
public class BOJ_2458 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 초기화
        List<List<Integer>> heightList = new ArrayList<>();
        List<List<Integer>> reverseList = new ArrayList<>();
        for(int i=0; i<N; i++){
            heightList.add(new ArrayList<>());
            reverseList.add(new ArrayList<>());
        }

        // List 생성
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            heightList.get(parent-1).add(child-1);
            reverseList.get(child-1).add(parent-1);
        }

        int count = 0;
        for(int i=0; i<N; i++){
            Queue<Integer> q = new ArrayDeque<>();
            boolean[] visited = new boolean[N];
            if(checkNode(heightList, i, q, visited) + checkNode(reverseList, i, q, visited) == N-1) count ++; //가는거 //오는거
        }
        System.out.println(count);
    }

    static private int checkNode(List<List<Integer>> list, int start, Queue<Integer> q, boolean[] visited){
        int checkNodeCnt = 0;

        q.offer(start);
        visited[start] = true;

        while(!q.isEmpty()){
            int cur = q.poll();
            for(Integer i : list.get(cur)){
                if(!visited[i]) {
                    q.offer(i);
                    visited[i] = true;
                    checkNodeCnt ++;
                }
            }
        }
        return checkNodeCnt;
    }
}
