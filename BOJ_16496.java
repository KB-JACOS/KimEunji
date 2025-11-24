import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_16496 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] str = new String[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) str[i] = st.nextToken();

        StringBuilder sb = new StringBuilder();

        Arrays.sort(str, (t1,t2) -> {
            return new BigDecimal(t2 + t1).compareTo(new BigDecimal(t1 + t2));
        });
        for(String s : str) sb.append(s);

        if(sb.toString().charAt(0) == '0') System.out.println(0);
        else System.out.println(sb);
    }
}
