import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_20920 {
    public static class Word{
        String key;
        Integer count;

        Word(String key, Integer count){
            this.key = key;
            this.count = count;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<N; i++){
            String str = br.readLine();
            if(str.length()<M) continue;
            map.put(str, map.getOrDefault(str, 0)+1);
        }
        List<Word> list = new ArrayList<>();
        for(String s : map.keySet()){
            list.add(new Word(s, map.get(s)));
        }
        Collections.sort(list,
                (a,b) -> {
                    if(a.count == b.count){
                        if(a.key.length() == b.key.length()) {
                            return a.key.compareTo(b.key);
                        }
                        return b.key.length() - a.key.length();
                    }
                    return b.count - a.count;
                }
        );

        for(Word w : list){
            sb.append(w.key).append("\n");
        }
        System.out.println(sb);
    }
}
