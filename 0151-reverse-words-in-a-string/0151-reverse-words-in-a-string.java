class Solution {
    public String reverseWords(String st) {
       String[] arr  = st.split(" ");
            StringBuilder sb = new StringBuilder();
        // System.out.println(Arrays.toString(arr));
        for(int i = arr.length -1 ; i >= 0; i--){
            String a = arr[i];
            int j = 0;
            while(j <  a.length() && a.charAt(j) == ' '){
                j++;
            }
            if(j < a.length())
            sb.append(a.substring(j, a.length()) + " ");
        }
        return sb.toString().trim();
    }
    
    boolean isAlphaNumeric(char c){
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }
                     
                     
    String reverse(char[] arr, int start, int end){
         while(start <= end){
            swap(arr, start++, end--);
         }
        return String.valueOf(arr);
    }
    
    void swap(char[] arr, int start, int end){
             char temp = arr[end];
             arr[end] = arr[start];
             arr[start] = temp; 
    }
}