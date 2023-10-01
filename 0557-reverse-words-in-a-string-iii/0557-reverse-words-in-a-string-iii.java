class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        String answer = "";
        for(int i = 0; i < arr.length - 1; i++) {
            String ss = arr[i];
            answer += reverse(ss.toCharArray());
            answer += " ";
        }
        answer += reverse(arr[arr.length - 1].toCharArray());
        return answer;
    }
    
    String reverse(char[] ar){
        
        for(int i = 0; i < ar.length/2; i++) {
            char temp = ar[ar.length-1-i];
            ar[ar.length-1-i] = ar[i];
            ar[i] = temp; 
        }
        
        return String.valueOf(ar);
    }
}