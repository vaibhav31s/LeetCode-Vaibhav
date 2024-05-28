class Solution {
    //pref binary slidingWindow
    public int equalSubstring(String s, String t, int maxCost) {
        int start = 0;
        int max = 0;
        int[] pref = new int[s.length()+1];
        
        for (int i = 1; i <= s.length(); i++) {
            pref[i] = pref[i - 1] + Math.abs(s.charAt(i-1) - t.charAt(i-1));
        }
        
        for (int i = 0; i <= s.length(); i++) {
            while ((pref[i] - pref[start]) > maxCost) {
                start++;
            }
            max = Math.max(max, i - start);
        }
        
        return max;
    }
    
    boolean isGood(String s, String t, int maxCost, int win, int[] pref) {
        int maxHere = Integer.MAX_VALUE;
        for (int i = 0; i <= s.length() - win; i++) {
            int curMax = pref[i + win] - pref[i];
            maxHere = Math.min(curMax, maxHere);
        }
        
        // System.out.println(win + " " + maxHere);
        return maxHere <= maxCost;
    }
}