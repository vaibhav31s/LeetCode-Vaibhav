class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if(Math.abs(s.length()- t.length()) > 1) return false;
        
        if(s.length() == 1 && t.length() == 1) return s.charAt(0) != t.charAt(0);
        int p1 = 0;
        int p2 = 0;
        int skip = 0;
        int min = s.length() < t.length() ? 1 : 2;
        if(s.length() == t.length()) min =0 ;
        while(p1 < s.length() && p2 < t.length()){
            if(s.charAt(p1) == t.charAt(p2)){
                p1++;
                p2++;
            }else{
                skip++;
                if(min == 2) p1++;
                else if(min == 1) p2++;
                else {
                    p1++;
                    p2++;
                }
            }
        }
        
        if(p1 < s.length()) skip++;
        else if(p2 < t.length()) skip++;
        
        return skip == 1 ? true : false;
        
        
    }
}