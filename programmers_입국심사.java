
class programmers_입국심사 {
    public long solution(int n, int[] times) {
        long answer = 0;
        long max = 0; //int로 하면 오버플로우 터짐
        for (int time : times){
            max = Math.max(max, time);
        }

        long s = times[0], e = (n / times.length +1) * max, mid;
        while(s <= e) {
            mid = (s+e) /2;
            long sum = 0;
            for(int time : times) {
                sum += mid / time;
            }
            if(sum >= n) {
                //줄여
                e = mid -1;
                answer = mid;
            } else if (sum < n) {
                s = mid + 1;
            }
        }
        return answer;
    }
}
