class Solution {
    public int coinChange(int[] coins, int amount) {
     
        long[] dp = new long[amount + 1];
        
        // int answer = (int) possible(coins, amount, dp);
        
        Arrays.fill(dp,  Integer.MAX_VALUE);
        dp[0] = 1;
        for (int remainAmount = 1; remainAmount <= amount; remainAmount++) {
             
                long minWay = Integer.MAX_VALUE;
                for (int coin : coins) {
                    if(remainAmount - coin < 0){ 
                        continue;
                    }
                    long way = dp[remainAmount - coin];
                    
                    if(way == Integer.MAX_VALUE) {
                        continue;
                    }
                    
                    
                    minWay = Math.min(1 + way, minWay);
                }

             dp[remainAmount] = minWay;
        }
        
        return  dp[amount] == Integer.MAX_VALUE ? -1 : (int) dp[amount] - 1 ;
    } 
    
   
    
}

// 1    2    5
// inf  inf  inf