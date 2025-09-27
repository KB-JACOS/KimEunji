import java.util.*;

class programmers_봉인된주문 {
    public String solution(long n, String[] bans) {
        String answer = "";

        List<Long> banList = new ArrayList<>();
        for(String ban : bans){
            int size = ban.length();
            long word = 0;

            for(int i=0; i<size; i++){
                long num = (long) ((ban.charAt(i) - 'a' + 1) * Math.pow(26, (size-i-1)));
                word += num;
            }

            banList.add(word);
        }

        Collections.sort(banList);

        for(Long banL : banList){
            if(n >= banL) n++;
        }

        while(n > 0){

            long na = (n-1) % 26;
            n = (n-1) / 26;

            answer = (char)(na + 97) + answer;

        }
        return answer;
    }
}
