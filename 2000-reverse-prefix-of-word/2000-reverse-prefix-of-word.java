class Solution {
    public String reversePrefix(String word, char ch) {
        StringBuilder toReverse = new StringBuilder();
        int pointer = 0;
        
        while (pointer < word.length()) {
            toReverse.append(word.charAt(pointer));
            if (word.charAt(pointer) == ch) {
                break;
            }
            pointer++;
        }
        if (pointer == word.length()) return word;
        
        toReverse.reverse();
        return toReverse.toString() + "" + word.substring(pointer + 1);
    }
}