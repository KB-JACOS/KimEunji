import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_17471 {
    static int N, total;
    static boolean[] comb;
    static int[] people;
    static List<List<Integer>> link;
    static int minSum = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        people = new int[N+1];
        comb = new boolean[N+1];

        total = 0;
        for(int i=1; i<=N; i++){
            people[i] = Integer.parseInt(st.nextToken());
            total += people[i];
        }

        link = new ArrayList<>();
        for(int i=0; i<=N; i++){
            link.add(new ArrayList<>());
        }
        for(int i=1; i<=N; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st2.nextToken());
            for(int j=0; j<t; j++){
                int tmp = Integer.parseInt(st2.nextToken());
                link.get(i).add(tmp);
            }
        }

        //모든 조합
        combination(1, 0);

        System.out.println((minSum == Integer.MAX_VALUE) ? -1 : minSum);
    }

    private static void combination(int start, int sum){
        solution(comb, sum);

        for(int i=start; i<=N; i++){
            if(!comb[i]) {
                comb[i] = true;
                combination(i + 1, sum+people[i]);
                comb[i] = false;
            }
        }
    }

    private static void solution(boolean[] comb, int sum){
        if(sum == total || sum == 0) return;

        int a = 0, b = 0;
        for(int i=1; i<=N; i++){
            if(!comb[i]) b=i;
            else a=i;

            if(a!=0 && b!=0) break;
        }

        //a그룹 - 연결되는지 파악하고 있으면 값 계산
        boolean[] visited = new boolean[N+1];
        for(int i=1; i<=N; i++){
            if(comb[i]){
                visited[i] = true;
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(a);

        while(!queue.isEmpty()){
            int cur = queue.poll();
            visited[cur] = false;
            for(int i: link.get(cur)){
                if(visited[i]){
                    visited[i] = false;
                    queue.add(i);
                }
            }
        }

        for(int i=1; i<=N; i++){
            if(visited[i]) return;
        }


        //b그룹 - 나머지 값들도 유효한지 파악
        boolean[] visited2 = new boolean[N+1];
        for(int i=1; i<=N; i++){
            if(!comb[i]){
                visited2[i] = true;
            }
        }

        Queue<Integer> queue2 = new ArrayDeque<>();
        queue2.add(b);

        while(!queue2.isEmpty()){
            int cur = queue2.poll();
            visited2[cur] = false;
            for(int i: link.get(cur)){
                if(visited2[i]){
                    visited2[i] = false;
                    queue2.add(i);
                }
            }
        }

        for(int i=1;i<=N;i++){
            if(visited2[i]) return;
        }


        //값 계산
        minSum = Math.min(minSum, Math.abs(total-2*sum));
    }
}
