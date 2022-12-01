class Solution {
    public boolean halvesAreAlike(String s) {
        int firstHalve = 0;
        int secondHalve = 0;
        HashSet<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U')
            ;
        
        int half = s.length() / 2;
        
        for(int i = 0; i < half; i++){
            char ch = s.charAt(i);
            if(vowels.contains(ch)) firstHalve++;
        }
        
        
        for(int i = half; i < s.length(); i++){
            char ch = s.charAt(i);
            if(vowels.contains(ch)) secondHalve++;
        }
        
        
        return firstHalve == secondHalve;
    }
}
// bo ok
//  1  1
     // ==

//text book
// 1    2
//    !=