import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_20191 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] S = br.readLine().toCharArray();
        String st = br.readLine(); char[] T = new char[st.length()];

        List<List<Integer>> alphaList = new ArrayList<>();
        for(int i =0; i<26; i++) alphaList.add(new ArrayList<>());

        for(int i = 0; i < st.length(); i++){
            char c = st.charAt(i); T[i] = c;

            //알파벳 위치 저장
            alphaList.get(c - 'a').add(i);
        }

        int count = 1, idx = -1;
        for(char s : S){
            List<Integer> tmp = alphaList.get(s - 'a');

            // 없으면 -1
            if(tmp.isEmpty()) {
                System.out.println(-1);
                return;
            }

            // 현재 저장된 idx 값과 비교해서 자신보다 크면서 가장 작은 값 찾기
            // 작으면 count ++;
            int num = findNum(idx, tmp);

            if(num <= idx) count ++;
            idx = num;
        }
        System.out.println(count);
    }

    private static int findNum(int idx, List<Integer> arr) {
        if (arr.isEmpty()) return -1;

        int lo = 0, hi = arr.size(); // [lo, hi)
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (arr.get(mid) <= idx) lo = mid + 1;
            else hi = mid;
        }

        if (lo < arr.size()) return arr.get(lo); // idx보다 큰 값 중 가장 작은 값
        return arr.get(0); // 없으면 새 라운드 → 가장 앞 인덱스
    }
}
