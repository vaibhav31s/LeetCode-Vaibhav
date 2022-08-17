class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morseCode = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        HashSet<String> set = new HashSet<>();
        for(String s : words){
            StringBuilder key = new StringBuilder();
            for(char ch : s.toCharArray()){
                int index = ch-'a';
                key.append(morseCode[index]);
            }
            set.add(key.toString());
        }
        
        return set.size();
    }
}