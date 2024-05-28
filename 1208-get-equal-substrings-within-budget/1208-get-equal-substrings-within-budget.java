class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int start = 0;
        int end = s.length();
        int answer = 0;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (isGood(s, t, maxCost, mid)) {
                answer = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return answer;
    }
    
    boolean isGood(String s, String t, int maxCost, int win) {
        
        int curMax = 0;
        for (int i = 0; i < win; i++) {
            curMax += Math.abs(s.charAt(i) - t.charAt(i));
        }
        
        int maxHere = curMax;
        for (int i = 0; i < s.length() - win; i++) {
            curMax -= Math.abs(s.charAt(i) - t.charAt(i));
            curMax += Math.abs(s.charAt(i + win) - t.charAt(i + win));
            maxHere = Math.min(curMax, maxHere);
        }
        
        // System.out.println(win + " " + maxHere);
        return maxHere <= maxCost;
    }
}