class Solution {
     long mod = 1000000007;
    public int numRollsToTarget(int n, int k, int target) {
        long[][] dp = new long[n + 1][target + 1];
     
        dp[0][0] = 1;
        for(int nn = 1; nn <= n; nn++) {
            for(int targett = 0;  targett <= target; targett++) {

                for(int i = 1; i <= k; i++) {
                    if((targett - i) < 0) break;
                    dp[nn][targett] += dp[nn - 1][targett - i];
                    dp[nn][targett] %= mod;
                }   
             
            }
         
        }
       return (int) dp[n][target]; 
    }
    long go(int n, int k, int target, long[][] dp) {
        if(target == 0 && n == 0) {
            return 1;
        }
        
        
        if(target < 0 || n < 0) return 0;
        
        if(dp[n][target] != -1) return dp[n][target];
        long count = 0;
        for(int i = 1; i <= k; i++) {
            count += go(n - 1, k, target - i,dp);
            count %= mod;
        }
        
        return dp[n][target] = count;
    }
}