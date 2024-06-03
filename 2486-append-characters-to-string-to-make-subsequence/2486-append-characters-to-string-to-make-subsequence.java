class Solution {
    public int appendCharacters(String s, String t) {
        int cur = 0;
        for (int i = 0; i < s.length(); i++) {
            if (cur < t.length() && s.charAt(i) == t.charAt(cur)) {
                cur++;
            }
        }
        return t.length() - cur;
    }
}