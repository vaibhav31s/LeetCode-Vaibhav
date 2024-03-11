class Solution {
    public String customSortString(String order, String s) {
        int[] map = new int[26];
        for (char ch : s.toCharArray()) map[ch - 'a']++;
        StringBuilder sb = new StringBuilder();
        for (char ch : order.toCharArray()) while (map[ch - 'a']-- > 0) sb.append(ch);
        for (char ch = 'a'; ch <= 'z'; ch++) while (map[ch - 'a']-- > 0) sb.append(ch);
        return sb.toString();
    }
}