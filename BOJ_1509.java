import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1509 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] array = br.readLine().toCharArray();
        int size = array.length;

        boolean[][] isPalindrome = new boolean[size][size];
        int[] dp = new int[size+1]; dp[0] = 0; dp[1] = 1;

        for(int i=0; i<size; i++) isPalindrome[i][i] = true;

        for(int i=2; i<=size; i++){
            dp[i] = dp[i-1] + 1;
            for(int j=1; j<i; j++){
                if(array[j-1] == array[i-1]){
                    if(isPalindrome[j][i-2] || j+1 == i){
                        isPalindrome[j-1][i-1] = true;
                        dp[i] = Math.min(dp[i], dp[j-1] + 1);
                    }
                }
            }
        }

        System.out.println(dp[size]);
    }
}
