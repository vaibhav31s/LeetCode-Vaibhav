class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        
        List<Integer> locations = new ArrayList<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (goal.charAt(0) == s.charAt(i)) {
                locations.add(i);
            }
        }
        
        int len = s.length();
        
        for (int ind : locations) {
            if (checker(s, goal, ind, len)) {
                return true;
            }    
        }
        
        return false;
    }
    
    boolean checker(String s, String goal, int ind, int len) {
        for (char ch : goal.toCharArray()) {
            if (ch == s.charAt(ind)) {
                ind++;
                ind %= len;
            } else return false;
        }
        return true;
    }
}