import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1461 {
    static int step = 0, max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            int dist = Integer.parseInt(st.nextToken());
            if(dist > 0) positive.add(dist);
            else negative.add(dist);
        }

        Collections.sort(positive, (a, b) -> b - a);
        Collections.sort(negative);

        List<Integer> positiveMemo = extractMemo(positive, M);
        List<Integer> negativeMemo = extractMemo(negative, M);

        calculateValue(positiveMemo);
        calculateValue(negativeMemo);

        System.out.println(step - max);
    }

    private static List<Integer> extractMemo(List<Integer> list, int M){
        List<Integer> memoList = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            if(i%M == 0){
                memoList.add(list.get(i));
            }
        }
        return memoList;
    }

    private static void calculateValue(List<Integer> memoList){
        for(int i=0;i<memoList.size();i++){
            step += Math.abs(memoList.get(i))*2;
            max = Math.max(max,Math.abs(memoList.get(i)));
        }
    }
}
