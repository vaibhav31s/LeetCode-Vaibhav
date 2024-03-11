class Solution {
    public String customSortString(String order, String s) {
        int[] map = new int[26];
        for (char ch : s.toCharArray()) map[ch - 'a']++;
        StringBuilder sb = new StringBuilder();
        for (char ch : order.toCharArray()) {
            int index = ch - 'a';
            while (map[index]-- > 0) sb.append(ch);
        }
        
        for (char ch = 'a'; ch <= 'z'; ch++) {
            int index = ch - 'a';
            while (map[index]-- > 0) sb.append(ch);
        }
        
        return sb.toString();
    }
}