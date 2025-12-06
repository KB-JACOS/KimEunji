import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2885 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        // 초콜릿 크기
        int chocolateSize = 1;

        while(K > chocolateSize){
            chocolateSize *= 2;
        }
        System.out.print(chocolateSize + " ");

        // 최소 커팅 수
        int cutCount = 0;
        while(K != chocolateSize){
            if(K > chocolateSize) K -= chocolateSize;
            chocolateSize /= 2;
            cutCount ++;
        }

        System.out.println(cutCount);
    }
}
