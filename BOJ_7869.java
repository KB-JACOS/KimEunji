import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_7869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double x1 = Double.parseDouble(st.nextToken());
        double y1 = Double.parseDouble(st.nextToken());
        double r1 = Double.parseDouble(st.nextToken());

        double x2 = Double.parseDouble(st.nextToken());
        double y2 = Double.parseDouble(st.nextToken());
        double r2 = Double.parseDouble(st.nextToken());

        double dist = Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));

        double result;
        if(dist >= r1 + r2) result = 0;
        else if(dist <= Math.abs(r1 - r2)) {
            double minR = Math.min(r1, r2);
            result = Math.PI * minR * minR;
        } else {
            double theta1 = 2 * Math.acos((r1*r1 + dist*dist - r2*r2) / (2*r1*dist));
            double theta2 = 2 * Math.acos((r2*r2 + dist*dist - r1*r1) / (2*r2*dist));
            result = r1*r1*(theta1 - Math.sin(theta1))/2 + r2*r2*(theta2 - Math.sin(theta2))/2;
        }
        System.out.printf("%.3f", result);
    }
}
