import java.io.*;
import java.util.*;

public class baekjoon_1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        for (char c : br.readLine().toCharArray()){
            leftStack.push(c);
        }

        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            String letter = br.readLine();
            char command = letter .charAt(0);
            switch (command) {
                case 'L':
                    if(!leftStack.isEmpty()) rightStack.push(leftStack.pop());
                    break;
                
                case 'D':
                    if(!rightStack.isEmpty()) leftStack.push(rightStack.pop());
                    break;

                case 'B':
                    if(!leftStack.isEmpty()) leftStack.pop();
                    break;
                
                case 'P':
                    char pLetter = letter.charAt(2);
                    leftStack.push(pLetter);
                    break;
            }
        }

        while(!leftStack.isEmpty()){
            rightStack.push(leftStack.pop());
        }
        
        while(!rightStack.isEmpty()){
            bw.write(rightStack.pop());
        }
        bw.flush();
        bw.close();
    }
}
