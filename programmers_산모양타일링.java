
import java.util.*;
public class programmers_산모양타일링 {
    static int count = -1;
    static List<int[]> tri;

    public static void main(String[] args) {
        System.out.println(solution(2, new int[]{0,1}));
    }

    public static int solution(int n, int[] tops) {
        int answer = 0;
        tri = new ArrayList<>();
        for(int i=1; i<=2*n; i++){
            tri.add(new int[]{i, i+1});
        }

        for(int i=0; i<tops.length; i++){
            if(tops[i] == 1){
                tri.add(new int[]{2*(i+1), 2*n + (i+1)});
            }
        }

        // for(int[] t: tri){
        //     System.out.println(Arrays.toString(t));
        // }
        //comb(0, 0, new ArrayList<>());
        return count;
    }

//    private static void comb(int start, int depth, List<Integer> tmp){
//        count ++;
//        System.out.println(tmp);
//        if(depth == tri.size()) return;
//
//        for(int i=start; i<tri.size(); i++){
//            for(Integer t : tmp) {
//                if(tri.get(t) == tri.get(i)[0] || tri.get(t).equals(tri.get(i)[1])) continue;
//            }
//
//            tmp.add(i);
//            comb(i+1, depth+1, tmp);
//            tmp.remove(tmp.size()-1);
//        }
//    }
}