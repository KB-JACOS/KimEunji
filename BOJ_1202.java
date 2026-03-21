import java.util.*;
import java.io.*;

public class BOJ_1202 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<int[]> list = new ArrayList<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list.add(new int[]{m, v});
        }

        Collections.sort(list, (a,b) -> a[0]-b[0]);

        int[] array = new int[K];
        for(int i=0; i<K; i++){
            array[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(array);

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->Integer.compare(b,a));

        int tmp = 0;
        long sum = 0;
        for(int a : array){
            while(tmp<list.size() && a >= list.get(tmp)[0]){
                pq.offer(list.get(tmp)[1]);
                tmp++;
            }

            if(!pq.isEmpty()) {
                sum += pq.poll();
            }
        }
        System.out.println(sum);
    }
}
