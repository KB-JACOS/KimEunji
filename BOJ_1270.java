import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_1270 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            HashMap<Long, Integer> map = new HashMap<>();
            boolean flag = false;

            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());

            for(int j=0; j<t; j++){
                long num = Long.parseLong(st.nextToken());
                map.put(num, map.getOrDefault(num, 0) + 1);
                if(map.get(num) > t/2){
                    System.out.println(num);
                    flag = true;
                    break;
                }
            }
            if(!flag) System.out.println("SYJKGW");
        }
    }
}
