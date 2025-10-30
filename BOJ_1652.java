import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        char[][] array = new char[N][N];
        for(int i=0; i<N; i++) array[i] = br.readLine().toCharArray();

        //System.out.println(Arrays.deepToString(array));

        int answer1 = 0;
        for(int i=0; i<N; i++){
            boolean flag = true;
            int count = 0;
            for(int j=0; j<N; j++){
                if(array[i][j] == '.'){
                    count ++;
                    if(count >= 2 && flag == true) {
                        answer1 ++;
                        flag = false;
                    }

                } else {
                    flag = true;
                    count = 0;
                }
            }
        }
        System.out.println(answer1);

        int answer2 = 0;
        for(int i=0; i<N; i++){
            boolean flag = true;
            int count = 0;
            for(int j=0; j<N; j++){
                if(array[j][i] == '.'){
                    count ++;
                    if(count >= 2 && flag == true) {
                        answer2 ++;
                        flag = false;
                    }

                } else {
                    flag = true;
                    count = 0;
                }
            }
        }
        System.out.println(answer2);
    }
}
