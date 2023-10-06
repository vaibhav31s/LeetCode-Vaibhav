class Solution {
    public int integerBreak(int n) {
         if (n <= 3) {
            return n - 1;
        }
        
        int ans = 1;
        while (n > 4) {
            ans *= 3;
            n -= 3;
        }
        
        return ans * n;
    }
    
    int go(int n, int[] dp) {
        if (n <= 3 ) {
           return n - 1;
        }
        if (dp[n] != 0) return dp[n];
        int max = n;
        for (int i = 1; i <= 60; i++) {
            if(n - i >= 0) {
               max = Math.max(go (n - i, dp) *( i), max);
            } else break;
        }   

        return dp[n] = max;
        
           
    }
}