class Solution {
    public int shortestWay(String source, String target) {
        //Using Set to Check Whether source contains all the targets chars //Base case
        Set<Character> checker = new HashSet<>();     
        for(char ch : source.toCharArray()) checker.add(ch);
        for(char ch : target.toCharArray()){
            if(!checker.contains(ch)) return -1;
        }
        
        
        
        int answer = 1;
        int p1 = 0;
        int p2 = 0;
    
        //bruteforce checks all the possible p1 to p2 from target is subsequnce of source
        while(p1 < target.length()){
            if(!isSubsequence(target.substring(p2, p1+1), source)){
                answer++;
                p2 = p1;
            }
            p1++;
        }
        
        
        
        return answer;
    }
      public boolean isSubsequence(String s, String t) {
        
        int p1 = 0;
        int  p2 = 0;
        for(int i = 0;i < t.length(); i++){
            
            if(p1 == s.length()) return true;
            
            char a = s.charAt(p1);
            char b = t.charAt(p2);
            
            if(a == b ){
                p1++;
                p2++;
            }else{
                p2++;
            }
            
        }
        
            if(p1 == s.length()) return true;
            
        
        
        return false;
    }
    
}