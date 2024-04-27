class Solution {
    public int longestIdealString(String s, int k) {
        int[] dp = new int[26];
        for (int i = 0; i < s.length(); i++) {   
            int ind = s.charAt(i) - 'a';
            int max = 1;
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (Math.abs(s.charAt(i) - ch) <= k) {
                    max = Math.max(1 + dp[ch - 'a'], max);
                } 
            }
            dp[ind] = max;
        }
        
        int ans = 0;
        for (int x : dp) ans = Math.max(ans, x);
        
        return ans;
    }
    
}
