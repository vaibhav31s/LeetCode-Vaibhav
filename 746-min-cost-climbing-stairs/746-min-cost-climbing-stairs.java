class Solution {
    
    public int minCostClimbingStairs(int[] cost) {
          int[] dp = new int[1001];
        int one = getCost(cost, 0, cost.length, dp);
        int two = getCost(cost, 1, cost.length, dp);

        return Math.min(one,two);
    }
    int getCost(int[] cost, int index, int clen, int[] dp){
        if(index == clen - 1 || index == clen -2) return cost[index];
        
        if(dp[index] != 0) return dp[index];
        int one = getCost(cost, index + 1, clen,dp);
        int two = getCost(cost, index + 2, clen,dp);
        
        dp[index] =  Math.min(one, two) +  cost[index];
        return dp[index];
    }
    
    
    
}