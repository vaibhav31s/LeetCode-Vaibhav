class Solution {
    public int countCharacters(String[] words, String chars) {
        int answer = 0;
        int[] freq = new int[26];
        for(char ch :  chars.toCharArray()) {
            freq[ch - 'a']++;
        } 
        
        int[] wordFreq = new int[26];
        
        outer:
        for (String word : words) {
            Arrays.fill(wordFreq, 0);
            for (char ch :  word.toCharArray()) {
                wordFreq[ch - 'a']++;
            } 
            for (int i = 0; i < 26; i++) {
                if (freq[i] - wordFreq[i] < 0) {
                    continue outer;
                }
            }
            
            answer += word.length();
        }
        return answer;
    }
}