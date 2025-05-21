import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1074 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        System.out.println(z(row, col));
    }

    public static int z(int i, int j) {
        if (i == 0 && j == 0) {
            return 0;
        }

        if (i % 2 != 0 && j % 2 != 0) {
            return z(i - 1, j - 1) + 3;
        }
        else if (i % 2 != 0) {
            return z(i - 1, j) + 2;
        }
        else if (j % 2 != 0) {
            return z(i, j - 1) + 1;
        }
        else {
            return z(i / 2, j / 2) * 4;
        }
    }
}
