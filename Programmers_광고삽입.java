import java.util.*;
class Programmers_광고삽입  {
    public String solution(String play, String adv, String[] logs) {
        String answer = "";
        int pSize = strToint(play);
        int aSize = strToint(adv);

        int[] init = new int[pSize+2];
        long[] dp = new long[pSize+2];

        for(int i=0; i<logs.length; i++){
            String[] sArr = logs[i].split("-");
            String start = sArr[0], end = sArr[1];
            init[strToint(start)]++;
            init[strToint(end)]--;
        }

        for(int i=1; i<pSize; i++){
            init[i] += init[i-1];
            dp[i] = dp[i-1] + init[i];
        }

        long max = dp[aSize-1], idx = 0;
        for(int i=aSize; i<=pSize; i++){
            if(max < dp[i] - dp[i-aSize]){
                max = dp[i] - dp[i-aSize];
                idx = (i-aSize) + 1;
            }
        }

        return intTostr(idx) ;
    }

    private int strToint(String s){
        String[] sArr = s.split(":");
        return 3600*Integer.parseInt(sArr[0])
                + 60*Integer.parseInt(sArr[1])
                + Integer.parseInt(sArr[2]);
    }

    private String intTostr(long i){
        String hour = String.valueOf(i/3600);
        String minute = String.valueOf((i%3600) / 60);
        String second = String.valueOf(i % 60);

        if(hour.length() == 1) hour = "0" + hour;
        if(minute.length() == 1) minute = "0" + minute;
        if(second.length() == 1) second = "0" + second;

        return hour + ":" + minute + ":" + second;
    }
}