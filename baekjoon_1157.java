import java.io.*;
import java.util.*;

public class baekjoon_1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String st = br.readLine().toUpperCase();
        int[] arr_ch = new int[26];

        for(char ch : st.toCharArray()){
            arr_ch[ch-'A']++;
        }

        int max=0;
        int maxChar=-1;
        boolean isSeveral = false;

        for(int i=0; i<26; i++){
            if(max < arr_ch[i]){
                max = arr_ch[i];
                maxChar = i;
                isSeveral = false;
            }else if(max == arr_ch[i]){
                isSeveral = true;
            }
        }

        System.out.println(!isSeveral ? (char)(maxChar+'A') : "?");
    }
}
