import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_24416 {
    static int fibCount = 0;
    static int fibonacciCount = 0;
    static int[] f = new int[41];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        fib(n);
        fibonacci(n);
        System.out.println(fibCount + " " + fibonacciCount);
    }

    public static int fib(int n) {
        if (n == 1 || n == 2) {
            fibCount++;
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    public static int fibonacci(int n) {
        if (n == 1 || n == 2) {
            f[n] = 1;
        }
        for (int i = 3; i <= n; i++) {
            fibonacciCount++;
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }
}
