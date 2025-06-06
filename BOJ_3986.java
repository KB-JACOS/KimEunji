import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int count = 0;
        for(int i = 0; i < n; i++) {
            Deque<Character> stack = new ArrayDeque<>();
            char[] chars = br.readLine().toCharArray();

            //짝수여야함
            if(chars.length % 2 != 0) continue;

            for (char c : chars) {
                //여는거(처음짝) -> 없거나 pop한거랑 다른거면 넣어
                if (stack.isEmpty() || stack.peek() != c) {
                    stack.push(c);
                }
                //닫는거(두번짝)
                else {
                    stack.pop();
                }
            }
            if (stack.isEmpty()) {
                count++;
            }
        }
        System.out.println(count);
    }
}
