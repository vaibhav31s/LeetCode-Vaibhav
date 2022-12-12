class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
       return dfs(n,dp);
    }
    int dfs(int n,int[] dp){
        if(n == 0) return 1;
        if(n < 0 ) return 0;
            if(dp[n] != 0) return dp[n];
        int one = dfs(n - 1,dp) ;
        int two = dfs(n - 2,dp);
        
        return  dp[n]  = one + two;
    }
}