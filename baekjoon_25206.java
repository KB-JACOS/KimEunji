import java.io.*;

public class baekjoon_25206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double credit=0, score=0, creditSum=0;

        String str = "";
        while((str=br.readLine())!=null && !str.isEmpty()){
            String[] stArr = str.split(" ");
            if(stArr[2].equals("P")){
                continue;
            }
            credit = Double.parseDouble(stArr[1]);
            creditSum += credit;
            score += credit * scoreChange(stArr[2]);
        }
        System.out.println(score/creditSum);
    }


    public static double scoreChange(String s){
        double score = switch(s){
            case "A+" -> 4.5;
            case "A0" -> 4.0;
            case "B+" -> 3.5;
            case "B0" -> {
                yield 3.0;
            }
            case "C+" -> 2.5;
            case "C0" -> 2.0;
            case "D+" -> 1.5;
            case "D0" -> 1.0;
            case "junbeom" -> 5.0;
            default -> 0.0;
        };
        return score;
    }
}

