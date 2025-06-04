class programmers_징검다리건너기 {
    public int solution(int[] stones, int k) {
        //try 3 -> 최대의 idx 다음꺼 보고 나중에 최소 (완탐)
        // int min = Integer.MAX_VALUE;
        // for(int i = 0 ; i+k <= stones.length; ){
        //     int max = Integer.MIN_VALUE;
        //     int idx = -1;
        //     for(int j = i; j < i+k; j++) {
        //         if(max < stones[j]){
        //             idx = j;
        //             max = stones[j];
        //         }
        //     }
        //     min = Math.min(min, max);
        //     i = idx + 1;
        // }
        // return min;

        //try 4
        //연속 k여야함. 초과하면 실패. 미만이면 성공
        //성공하면 그보다 큰 값 되는지 보기
        //실패하면 작은 값 보기
        // 코테 화이팅!!!
        int start = 0, end = 1; //start는 k==1 일때 봐야해서 0부터 보기

        for(int stone : stones){
            end = Math.max(end, stone);
        }

        int answer = 0;
        while(start <= end){
            int mid = (start + end) / 2;
            int count = 0;
            for(int stone : stones) {

                if(stone <= mid) {
                    count ++;
                    if(count >= k) break;
                }
                else {
                    count = 0;
                }
            }

            if(count < k){ //성공
                start = mid + 1;
                answer = start;
            } else { //실패
                end = mid - 1;
            }
        }
        return answer;
    }
}