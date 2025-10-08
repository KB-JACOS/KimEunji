class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i=0; i<n; i++){
            int tmp = arr1[i] | arr2[i];
            
            StringBuilder sb = new StringBuilder();
            for(int j=n-1; j>=0; j--){
                //비트마스킹
                if((tmp & 1<<j) == 0) sb.append(' ');
                else sb.append('#');
            }
            answer[i] = sb.toString();
        }
        return answer;
    }
}

// class Solution {
//     public String[] solution(int n, int[] arr1, int[] arr2) {
//         String[] answer = new String[n];
//         for(int i=0; i<n; i++){
//             answer[i] = "";
//             String a1 = tenToTwo(arr1[i], n);
//             String a2 = tenToTwo(arr2[i], n);
            
//             for(int j=0; j<n; j++){
//                 if(a1.charAt(j) == '0' && a2.charAt(j) == '0'){
//                     answer[i] += ' ';
//                 } else{
//                     answer[i] += '#';
//                 }
//             }
//         }
//         return answer;
//     }
    
//     private String tenToTwo(int num, int n){
//         String tmp = "";
//         while(num>=1){
//             tmp = String.valueOf(num % 2) + tmp;
//             num /= 2;
//         }
//         while(tmp.length() < n){
//             tmp = '0' + tmp;
//         }
//         return tmp;
//     }
// }
