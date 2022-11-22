class Solution {
    
    public int numSquares(int n) {
        Integer[] dp = new Integer[n + 1];
        
        return dfs(n , dp) - 1;
    }
    
    
    int dfs(int n, Integer[] dp){
        if(n == 0) return 1;
        if(n < 0) return 0;
        int min = Integer.MAX_VALUE;
        if(dp[n] != null) return dp[n];
        for(int i = 1; i <= 100; i++){
            if((i * i ) <= n){
              min = Math.min(1 +  dfs(n - (i*i),dp), min);
            }else break;
        }
        
        return dp[n] = min;
        
    }
    
}