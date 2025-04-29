//sqrt(G+기억^) = 현
//오름차순, 자연수, 없으면 -1

import java.io.*;

public class BOJ_1484_refact {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long G = Integer.parseInt(br.readLine());

        boolean flag = false;
        int start = 1; int end = 2;
        while(end<=100000){
            long diff = end*end - start*start;
            if(diff == G){
                System.out.println(end);
                flag = true;
            }

            if(diff>G){
                start++;
            }else{
                end++;
            }
        }
        if(!flag){
            System.out.println(-1);
        }
    }
}
