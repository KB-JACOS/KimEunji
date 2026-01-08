import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2513 {
    public static int N, K, S, minDist = 0;

    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //아파트 단지 수
        K = Integer.parseInt(st.nextToken()); //통학버스 정원
        S = Integer.parseInt(st.nextToken()); //학교 위치

        List<int[]> leftStudents = new ArrayList<>(); //위치, 학생 수
        List<int[]> rightStudents = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int location = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());
            if (location >= S) rightStudents.add(new int[]{location, number});
            else leftStudents.add(new int[]{location, number});
        }

        //구현
        Collections.sort(leftStudents, (a, b) -> a[0] - b[0]); //오름차순
        Collections.sort(rightStudents, (a, b) -> b[0] - a[0]); //내림차순

        calcDist(leftStudents);
        calcDist(rightStudents);

        System.out.println(minDist);
    }

    private static void calcDist(List<int[]> students) {
        int bs = 0; // 지금 버스에 타있는 학생 수
        int far = 0; // 지금 가장 먼 거리

        for(int[] s : students) {
            int loc = s[0], num = s[1];
            while(num > 0){
                if(bs == 0) far = loc; // 방금 출발

                // 최대는 가능한 수, 안되면 현재 내 수
                int take = Math.min(num, K - bs);
                num -= take;
                bs += take;

                // 정원 다 참 -> 다 내림
                if(bs == K){
                    minDist += Math.abs(S - far) * 2;
                    far = 0; bs = 0;
                }
            }
            //System.out.println(minDist);
        }

        // 버스에 타있는 학생
        if(bs > 0) minDist += Math.abs(S - far) * 2;
    }
}
