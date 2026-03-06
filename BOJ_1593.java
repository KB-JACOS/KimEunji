import java.util.*;
import java.io.*;

public class BOJ_1593 {
    public static void main(String[] args) throws IOException{
        // A = 65, a = 97
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int WSize = Integer.parseInt(st.nextToken());
        int SSize = Integer.parseInt(st.nextToken());

        String W = br.readLine(); //52개
        int[] alpha = new int[52];

        for(int i=0; i<W.length(); i++){
            alpha[num(W.charAt(i))]++;
        }

        String S = br.readLine();
        int count = 0;

        int left = 0, right = WSize-1;

        //초기 윈도우
        for(int i=left; i<=right; i++){
            alpha[num(S.charAt(i))]--;
        }

        while (true) {
            if(isValid(alpha)) count++;

            //다음 단계로 넘어가기
            right ++;
            if(right>=SSize) break;

            alpha[num(S.charAt(right-WSize))]++;
            alpha[num(S.charAt(right))]--;
        }

        System.out.println(count);
    }

    private static int num(char tmpChar){
        //소문자
        if('a' <= tmpChar) return tmpChar-'A'-6;
        //대문자
        return tmpChar -'A';
    }

    private static boolean isValid(int[] alpha){
        for(int a : alpha){
            if(a<0) return false;
        }
        return true;
    }
}