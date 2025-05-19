import java.io.*;

// "셋째 자리 버림"은 avg[i] ≤ 값 < avg[i]+0.001 범위를 만족하는지 확인
// 1e-9는 부동소수점 오차로 인해 발생할 수 있는 비교 오류를 방지하기 위한 오차 허용 범위
public class BOJ_1206 {
    public static void main(String[] args) thrㅎows IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        double[] avg = new double[N];

        for (int i = 0; i < N; i++) {
            avg[i] = Double.parseDouble(br.readLine());
        }
        for (int people = 1; people <= 10000; people++) {
            boolean allOk = true;
            for (int i = 0; i < N && allOk; i++) {
                boolean ok = false;
                for (int sum = 0; sum <= people * 10; sum++) {
                    double trueAvg = (double) sum / people;

                    // 핵심: 버림 기준 → avg[i] ≤ trueAvg < avg[i] + 0.001
                    if (trueAvg + 1e-9 >= avg[i] && trueAvg < avg[i] + 0.001 - 1e-9) {
                        ok = true;
                        break;
                    }
                }
                if (!ok) allOk = false;
            }
            if (allOk) {
                System.out.println(people);
                return;
            }
        }
    }
}
