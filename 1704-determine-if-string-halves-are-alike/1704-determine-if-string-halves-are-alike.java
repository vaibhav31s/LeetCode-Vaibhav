class Solution {
    public boolean halvesAreAlike(String s) {
        char[] vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        
        int firstHalf = 0;
        int secondHalf = 0;
        
        int n = s.length();
        int half = n / 2;
        
        for(int i = 0; i < half; i++){
            char ch = s.charAt(i);
            for(char x : vowels) {
                if(x == ch) firstHalf++;
            }
        }
        
        
        for(int i = half; i < n; i++){
            char ch = s.charAt(i);
            for(char x : vowels) {
                if(x == ch) secondHalf++;
            }
        }
        
        return firstHalf == secondHalf;
    }
}
//bo ok
// 1  1
//  ==

//text book
//1     2
//  != 

// Space : o(1)

// Time  : o(n) 