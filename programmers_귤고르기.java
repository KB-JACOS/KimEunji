import java.util.*;
import java.io.*;

class Solution {.ㅓㅁ
    public int solution(int k, int[] tangerine) {
        int n = tangerine.length;
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int t : tangerine){
            map.put(t, map.getOrDefault(t, 0)+1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(Integer key : map.keySet()){
            pq.offer(map.get(key));
        }
        
        int answer = 0;
        int count = 0;
        while(true){
            count += pq.poll();
            answer ++;
            
            if(count >= k){
                break;
            }
        }
        
        return answer;
    }
}
