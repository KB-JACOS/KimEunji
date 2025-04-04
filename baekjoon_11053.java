import java.io.*;
import java.util.*;

public class baekjoon_11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] numSequence = new int[N];
        int[] memo = new int[N];

        for(int i=0;i<N;i++){
            numSequence[i] =  Integer.parseInt(st.nextToken());
            memo[i] = 1;
        }

        int lengthMax = 1;
        for(int i=0;i<N;i++){
            int max = -1;
            for(int j=0;j<i;j++){
                if( numSequence[i]>numSequence[j] ){
                    max = Math.max(memo[j], max);       
                }
            }
            memo[i] = max!=-1 ? max + 1 : 1;
            lengthMax = Math.max(memo[i], lengthMax);
        }
        
        System.out.println(lengthMax);
    }
}