//sqrt(G+기억^) = 현
//오름차순, 자연수, 없으면 -1

import java.io.*;

public class BOJ_1484 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long G = Integer.parseInt(br.readLine());

        long range = (G+1)/2 -1;
        boolean isFalse = true;

        for(long i=1; i<=range; i++){
            long remember = i*i;
            double cur = Math.sqrt(G+remember);
            if(cur == (long)cur){
                System.out.println((long) cur);
                isFalse = false;
            }
        }
        if(isFalse){
            System.out.println(-1);
        }
    }
}
