class Solution {
    public String sortVowels(String s) {
        char[] str = s.toCharArray();
        PriorityQueue<Character> pq = new PriorityQueue<>();
        List<Integer> indexes = new ArrayList<>();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if(isVowel(ch)) {
                indexes.add(i);
                pq.add(ch);
            }
        }
        
        for (int ind : indexes) {
            str[ind] = pq.poll();
        }
        return String.valueOf(str);
    }
    
    boolean isVowel(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
               c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' );
    }
}