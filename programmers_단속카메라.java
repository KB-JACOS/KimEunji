import java.util.*;

public class programmers_단속카메라 {
    public int solution(int[][] routes) {
        int answer = 1;
        Arrays.sort(routes, (a,b)->a[1]-b[1]);

        int y = routes[0][1];

        for(int i=1; i<routes.length; i++){
            if(y < routes[i][0]){
                answer ++; //혼자
                y = routes[i][1];
            }
        }

        return answer;
    }
}

// [10,50],[15,20],[40,60]
// [15,20],[10,50],[40,60]
