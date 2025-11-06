import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class BOJ_1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q1 = new PriorityQueue<>((a, b) -> b - a);
        Queue<Integer> q2 = new PriorityQueue<>((a, b) -> a - b);

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());

            // q1의 최대보다 num이 크면 q2에 넣기
            if(!q1.isEmpty() && q1.peek() < num) q2.add(num);
            else q1.add(num);

            // q1이 q2보다 하나 더 많게 아니면 같게
            if(q2.size() - q1.size() >= 1) {
                q1.add(q2.poll());
            }
            else if(q1.size() - q2.size() >= 2) {
                q2.add(q1.poll());
            }

            sb.append(q1.peek()).append("\n");
        }
        System.out.println(sb);
    }
}
