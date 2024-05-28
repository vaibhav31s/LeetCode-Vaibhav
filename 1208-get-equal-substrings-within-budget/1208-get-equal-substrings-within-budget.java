class Solution {
    //pref binary slidingWindow
    public int equalSubstring(String s, String t, int maxCost) {
        int start = 0;
        int end = s.length();
        int answer = 0;
        int[] pref = new int[s.length()+1];
        
        for (int i = 1; i <= s.length(); i++) {
            pref[i] = pref[i - 1] + Math.abs(s.charAt(i-1) - t.charAt(i-1));
        }
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (isGood(s, t, maxCost, mid, pref)) {
                answer = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return answer;
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