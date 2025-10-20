import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_12904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        StringBuilder T = new StringBuilder(br.readLine());

        for(int i=T.length();i>S.length();i--){
            if(T.charAt(i-1) == 'A') T.deleteCharAt(i-1);
            else{
                T.deleteCharAt(i-1);
                T.reverse();
            }
        }

        if(S.equals(T.toString())){
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
