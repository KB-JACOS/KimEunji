import java.util.*;
import java.lang.*;
import java.io.*;

public class baekjoon_10988 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();
        
        int check = 1;
        for(int i=0; i<st.length()/2; i++){
            if(st.charAt(i) != st.charAt(st.length()-i-1)){
                check = 0;
                break;
            }
        }
        
        System.out.println(check);
    }
}
