class Solution {
    public int coinChange(int[] coins, int amount) {
     
        long[] dp = new long[amount + 1];
        
        int answer = (int) possible(coins, amount, dp);
        
        return answer == Integer.MAX_VALUE ? -1 :  answer - 1 ;
    } 
    
    long possible(int[] coins, int amount, long[] dp) {
        if(amount == 0) return 1;
        
        if(amount < 0) return Integer.MAX_VALUE;
        
        if(dp[amount] != 0) return dp[amount];
        
        long minWay = Integer.MAX_VALUE;
        for (int coin : coins) {
            
            long way = possible(coins, amount - coin, dp);
            if(way == Integer.MAX_VALUE) continue;
            minWay = Math.min(1 + way, minWay);
        }
        
        return dp[amount] = minWay;
    }
    
    
}

// 1    2    5
// inf  inf  inf