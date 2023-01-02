class Solution {
    public boolean detectCapitalUse(String word) {
        if(word.length() == 1){
            return true;
        }
        
        int capital = 0;
        int small = 0;
        
        for(char ch : word.toCharArray()){
            if(ch >= 'a' && ch <= 'z'){
                small++;
            }else{
                capital++;
            }
            
            
        }
        
        if(capital == word.length() || small == word.length() || ((word.charAt(0) >= 'A' && word.charAt(0) <= 'Z') &&  small == word.length()-1)){
            return true;
        }
        
        return false;
    }
}