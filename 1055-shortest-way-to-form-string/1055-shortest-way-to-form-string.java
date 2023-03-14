class Solution {
    public int shortestWay(String source, String target) {
        int i = 0;
        int j = 0;
        Set<Character> set = new HashSet<>();
        // Set<Integer> set1 = new HashSet<Character>();
        // f
        for(char ch : source.toCharArray()) set.add(ch);
        for(char ch : target.toCharArray()){
            if(!set.contains(ch)) return -1;
        }
        int answer = 0;

        while(j < target.length()){
            String s = target.substring(i,j+1);
            if(isSubsequence(s,source)){
                
            }else{
                i = j;
                answer++;
            } 
             j++;
        }
        // isSubsequence(s,source) answer++;
        return answer+1;
        
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