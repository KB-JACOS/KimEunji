import java.io.*;
import java.util.*;

public class BOJ_2800 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] charArr = br.readLine().toCharArray();

        Stack<Integer> stack = new Stack<>();
        ArrayList<int[]> parentheses = new ArrayList<>();
        ArrayList<Integer> tmpArr;
        for (int i = 0; i < charArr.length; i++) {
            if(charArr[i]=='('){
                stack.push(i);
            }
            if(charArr[i]==')'){
                parentheses.add(new int[]{stack.pop(),i});
            }
        }

        Set<String> resultSet = new TreeSet<>();
        for(int i=1; i < 1<<parentheses.size();i++){
            tmpArr = new ArrayList<>();
            for(int j=0; j < parentheses.size();j++){
                if((i & 1<<j) != 0){
                    tmpArr.add(parentheses.get(j)[0]); //start
                    tmpArr.add(parentheses.get(j)[1]); //end
                }
            }
            StringBuilder sb = new StringBuilder();
            for(int k=0; k<charArr.length; k++){
                if(!tmpArr.contains(k)){
                    sb.append(charArr[k]);
                }
            }
            resultSet.add(sb.toString());
        }

        for (String s : resultSet) {
            System.out.println(s);
        }
    }
}
