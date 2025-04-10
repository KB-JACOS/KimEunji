import java.io.*;
import java.util.*;

public class baekjoon_1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K =  Integer.parseInt(st.nextToken());
        int N =  Integer.parseInt(st.nextToken());

        int[] numArray = new int[K];
        for(int i=0; i<K; i++){
            int num = Integer.parseInt(br.readLine());
            numArray[i] = num;
        }

        Arrays.sort(numArray);

        long left=1, right=numArray[K-1], mean=0;
        List<Long> point = new ArrayList<Long>();

        while(left<=right){
            mean = (long)(left+right)/2;
            int answer = 0;
            for(int num : numArray){
                answer += (long)num/mean;
            }
            if(answer>=N){
                left = mean+1;
                point.add(mean);
            }else if(answer<N){
                right = mean-1;
            }
        }
        Collections.sort(point, Collections.reverseOrder());
        System.out.println(point.get(0));
    }
}
