import java.util.*;
import java.io.*;

public class baekjoon_1802 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            String st = br.readLine();

            int[] intArray = new int[st.length()];
            for(int i=0; i<st.length(); i++){
                intArray[i] = st.charAt(i) - '0';
            }

            int left=0, right=intArray.length-1;
            boolean isFold = true;
            while(left<right && isFold){
                for(int i=left, j=right; i<right/2; i++,j--){
                    if(intArray[i] + intArray[j] != 1){
                        isFold = false;
                        break;
                    }
                }
                right=(int)right/2 -1;
            }
            System.out.println(isFold? "YES": "NO");
        }
    }
}