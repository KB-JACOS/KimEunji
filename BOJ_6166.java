import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_6166 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            int N = Integer.parseInt(br.readLine());
            if(N == 0) break;

            String str = br.readLine().toUpperCase().replace(" ", "");

            StringBuilder sb = new StringBuilder();
            int size = str.length();

            if(size < N){
                System.out.println(str);
                continue;
            }
            char[] chars = new char[size];

            int j = 0;
            int start = 0;

            for(int i=0; i<size; i++){
                chars[j] = str.charAt(i);
                j+=N;
                if(j>=size){
                    start ++;
                    j = start;
                }
            }

            for(char c : chars) sb.append(c);
            System.out.println(sb);
            // System.out.println(new String(chars));
        }
    }
}
