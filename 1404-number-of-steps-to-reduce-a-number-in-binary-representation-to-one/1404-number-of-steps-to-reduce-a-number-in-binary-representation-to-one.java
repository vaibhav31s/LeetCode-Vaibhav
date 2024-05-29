class Solution {
    public int numSteps(String s) {
        int answer = 0;
        char[] arr= s.toCharArray();
        int last = s.length() - 1;
        int count = 0;

        while (last >= 0 && arr[last] == '0') {
            last--;
            count++;
        }
        
        answer += count;
        count = 0;
        
        if (last == 0) {
            return answer;
        }
        
        int lastLast = last;
        // int count =0; 
        while (last >=0) {
            if (arr[last] == '1') {
                count++;
                last--;
            } else {
                arr[last] = '1';
                
                answer +=  1 + count;
                count = 0;
            }
        }
      
        answer += 1 + count;
        return answer;
    }
}
