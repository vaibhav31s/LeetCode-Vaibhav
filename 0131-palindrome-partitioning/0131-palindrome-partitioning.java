class Solution {
        List<List<String>> answer =new ArrayList<>();
    public List<List<String>> partition(String s) {
        List<String> temp = new ArrayList<>();
        dfs(s, 0, temp);
        return answer;
        
    }
    
    
    void dfs(String s, int start,  List<String> temp){
       if(start == s.length()){
           answer.add(new ArrayList<>(temp));
       }
        
       for(int i = start; i < s.length(); i++){
           if(checkPalindrome(s, start, i)){
               temp.add(s.substring(start, i+1));
               // System.out.println(temp);
               
               dfs(s, i+1, temp);
                               
               temp.remove(temp.size()-1);
           }
       }
    }
    
    
   public boolean checkPalindrome(String str, int startIndex, int lastIndex){
        while(startIndex <= lastIndex){
            if(str.charAt(startIndex) != str.charAt(lastIndex))
                return false;
            startIndex++;
            lastIndex--;
        }
        return true;
    }
}