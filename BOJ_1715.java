import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class BOJ_1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> q = new PriorityQueue<>();
        for(int i=0; i<N; i++) q.offer(Integer.parseInt(br.readLine()));

        int count = 0;
        while(q.size()>=2){
            int sum = q.poll() + q.poll();
            count += sum;
            q.offer(sum);
        }
        System.out.println(count);
    }
}
