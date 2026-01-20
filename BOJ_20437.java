import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_20437 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());

            List<List<Integer>> alpha = new ArrayList<>();
            for(int i=0; i<26; i++) alpha.add(new ArrayList<>());
            for(int i=0; i<W.length(); i++) alpha.get(W.charAt(i) - 'a').add(i);

//            System.out.println(alpha);

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for(List<Integer> ap : alpha){
                if(ap.size()>=K){
                    for(int i=0; i+K-1<ap.size(); i++){
                        min = Math.min(min, ap.get(i+K-1)-ap.get(i));
                        max = Math.max(max, ap.get(i+K-1)-ap.get(i));
                    }
                }
            }
            if(min==Integer.MAX_VALUE) {
                sb.append("-1\n");
                continue;
            }

            sb.append(min+1).append(" ").append(max+1).append("\n");
        }
        System.out.println(sb);
    }
}
