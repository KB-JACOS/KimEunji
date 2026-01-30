import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1234 {
    static int N;
    static long sum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        treeCount(R, G, B, 1, 1);
        System.out.println(sum);
    }

    private static void treeCount(int R, int G, int B, long count, int depth){
        if(depth > N){
            sum += count;
            return;
        }

        if(depth <= R){
            treeCount(R-depth, G, B, count, depth + 1);
        }
        if(depth <= G){
            treeCount(R, G-depth, B, count, depth + 1);
        }
        if(depth <= B){
            treeCount(R, G, B-depth, count, depth + 1);
        }

        if(depth%2 == 0){
            long tmp = factorial(depth) / (factorial(depth/2) * factorial(depth/2));
            if(depth/2 <= R && depth/2 <= G){
                treeCount(R-depth/2, G-depth/2, B, count*tmp, depth + 1);
            }
            if(depth/2 <= G && depth/2 <= B){
                treeCount(R, G-depth/2, B-depth/2, count*tmp, depth + 1);
            }
            if(depth/2 <= R && depth/2 <= B){
                treeCount(R-depth/2, G, B-depth/2, count*tmp, depth + 1);
            }
        }
        if(depth%3 == 0){
            long tmp = factorial(depth) / (factorial(depth/3) * factorial(depth/3) *  factorial(depth/3));
            if(depth/3 <= R && depth/3 <= G && depth/3 <= B){
                treeCount(R-depth/3, G-depth/3, B-depth/3, count*tmp, depth + 1);
            }
        }
    }
    private static long factorial(int n){
        long num = 1;
        for(int i=1; i<=n; i++){
            num = num*i;
        }
        return num;
    }
}