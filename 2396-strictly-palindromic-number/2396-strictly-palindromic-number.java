class Solution {
    public boolean isStrictlyPalindromic(int n) {
       
    return false;
        }
    
    boolean isPalindrom(char[] arr, int start, int end) {
        while(start <= end){
            if(arr[start] == arr[end]){
                start++;
                end--;
            }else return false;
        }
        return true;
    }
    String base_convert(String num, int source, int destination){
        return Integer.toString(Integer.parseInt(num, source), destination);
    }

}