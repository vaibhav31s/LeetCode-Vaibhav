class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        HashMap<Character, Integer> first = new HashMap<>();
        HashMap<Character, Integer> second = new HashMap<>();
        
        for (char ch : s1.toCharArray()) {
            first.put(ch, first.getOrDefault(ch, 0) + 1);
        }
        
        for (int i = 0; i < s1.length(); i++) {
            char ch = s2.charAt(i);
            second.put(ch, second.getOrDefault(ch, 0) + 1);
        }
        
        if (first.equals(second)) return true;
        
        for (int i = s1.length(); i < s2.length(); i++) {
            char last = s2.charAt(i - s1.length());
            second.put(last, second.getOrDefault(last, 0) - 1);
            if (second.get(last) == 0) second.remove(last);
            char ch = s2.charAt(i);
            second.put(ch, second.getOrDefault(ch, 0) + 1);
        
            if (first.equals(second)) return true;
        }
        
        return false;
    }
}