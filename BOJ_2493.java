import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] tops = new int[N];
        for(int i=0; i<N; i++){
            tops[i] = Integer.parseInt(st.nextToken());
        }

        Stack<int[]> higher = new Stack<>(); //val, num

        for(int i=0; i<N; i++){
            while(!higher.isEmpty() && higher.peek()[0]<tops[i]){
                higher.pop();
            }

            if(higher.isEmpty()) sb.append(0).append(" ");
            else sb.append(higher.peek()[1]+1).append(" ");

            higher.push(new int[]{tops[i], i});
        }
        System.out.println(sb);
    }
}
