import java.io.*;
import java.util.*;

public class BOJ_15831 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        String[] array = br.readLine().split("");

        int start = 0;
        int end = 0;
        int result = 0;

        int blackNum = 0;
        int whiteNum = 0;
        int len = 0;
        while (end < n) {
            if(blackNum > b){
                if (array[start].equals("B")) {
                    blackNum--;
                } else if (array[start].equals("W")) {
                    whiteNum--;
                }
                len--;
                start++;
            } else {
                if (array[end].equals("B")) {
                    blackNum++;
                } else if (array[end].equals("W")) {
                    whiteNum++;
                }
                len++;
                end++;
            }

            if (blackNum <= b && whiteNum >= w) {
                result = Math.max(result, len);
            }
        }
        System.out.println(result);
    }
}
