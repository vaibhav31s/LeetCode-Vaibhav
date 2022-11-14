class Solution {
    public int minCostClimbingStairs(int[] cost) {
        Integer[] dp = new Integer[1001];
        Integer[] dp1 = new Integer[1001];

        int a = helper(cost, cost.length - 1,dp);
        int b = helper(cost, cost.length - 2,dp1);
        return Math.min(a, b);
    }
    int helper(int[] cost, int i,Integer[] dp){
        if(i == 1 || i == 0) return cost[i];
        if(dp[i] != null) return dp[i];
        
        return dp[i] = Math.min(helper(cost, i - 1 ,dp) + cost[i], helper(cost, i - 2 ,dp) + cost[i]);
    }
}