import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_17471 {
    static int N;
    static List<List<Integer>> combiList = new ArrayList<>();;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] people = new int[N+1];

        int total = 0;
        for(int i=1; i<=N; i++){
            people[i] = Integer.parseInt(st.nextToken());
            total += people[i];
        }

        List<List<Integer>> link = new ArrayList<>();
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

        //System.out.println(link);

        //모든 조합
        combination(1, new ArrayList<>());
        combiList.remove(0); //공집합 제외

        //System.out.println(combiList);

        //연결되는지 파악하고 있으면 값 계산
        int minSum = Integer.MAX_VALUE;
        for(List<Integer> list : combiList){
            boolean flag1=true, flag2=true;
            int sum = 0;
            boolean[] visited = new boolean[N+1];
            for(int i: list){
                visited[i] = true;
                sum += people[i];
            }
            //유효한 list인지 파악
            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(list.get(0));
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

            for(int i: list){
                if(visited[i]){
                    flag1 = false;
                    break;
                }
            }
            if(!flag1) continue;

            //System.out.println(list + " : yes" );
            //나머지 값들도 유효한지 파악

            boolean[] visited2 = new boolean[N+1];
            int min = Integer.MAX_VALUE;
            for(int i=1; i<=N; i++){
                if(list.contains(i)){
                    continue;
                } else {
                    min = Math.min(min, i);
                    visited2[i] = true;
                }
            }
            //유효한 list인지 파악
            if(min == Integer.MAX_VALUE){
                continue;
            }

            //System.out.println(list + " : queue전" );

            Queue<Integer> queue2 = new ArrayDeque<>();
            queue2.add(min);
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
            //System.out.println(list + " : queue후" );

            //System.out.println(Arrays.toString(visited2));
            for(int i=1; i<=N; i++){
                // System.out.println(i);
                if(!list.contains(i) &&  visited2[i]){
                    //System.out.println(i + " : yes");
                    flag2 = false;
                    break;
                }
            }
            if(!flag2) continue;

            minSum = Math.min(minSum, Math.abs(total-2*sum));
            //System.out.println(minSum);
        }
        if(minSum == Integer.MAX_VALUE){
            System.out.println(-1);
        }
        else System.out.println(minSum);
    }

    private static void combination(int start, List<Integer> list){
        combiList.add(new ArrayList<>(list));

        for(int i=start; i<=N; i++){
            list.add(i);
            combination(i+1, list);
            list.remove(list.size()-1);
        }
    }
}
