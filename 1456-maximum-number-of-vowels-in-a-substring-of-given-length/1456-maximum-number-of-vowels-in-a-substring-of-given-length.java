class Solution {
    public int maxVowels(String s, int k) {
        int answer = 0;
        
        int cur = 0;
        for(int i = 0; i < s.length(); i++){
                
            if(i < k){
                cur += isVowel(s.charAt(i)) ? 1 : 0;
            }else{
                
                cur -= isVowel(s.charAt(i-k)) ? 1 : 0;
                cur += isVowel(s.charAt(i)) ? 1 : 0;
                
                
                
            }answer = Math.max(cur, answer);
            
        }
        
        return answer;
    }
    
    private boolean isVowel(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') return true;
        
        return false;
    }
}