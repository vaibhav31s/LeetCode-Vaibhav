class Solution {
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