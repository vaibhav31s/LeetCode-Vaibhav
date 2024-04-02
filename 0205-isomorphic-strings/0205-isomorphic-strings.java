class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        int cur = 0;
        for (char ch : s.toCharArray()) 
            map.putIfAbsent(ch, cur++);
        
        HashMap<Character, Integer> map2 = new HashMap<>();
        cur = 0;
        for (char ch : t.toCharArray()) 
            map2.putIfAbsent(ch, cur++);
        
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) != map2.get(t.charAt(i))) return false;
        }
        
        return true;
    }
}