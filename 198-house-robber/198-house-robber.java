class Solution {
    int max = 0;
    public int rob(int[] houses) {
        Integer[] dp = new Integer[houses.length];
       
        return helper(houses, 0, dp);
    }
    
    int helper(int[] houses, int index, Integer[] dp){
        
        if(index >= houses.length) return 0;
        
        if(dp[index] != null) return dp[index];
        
        
        return dp[index]= Math.max(helper(houses, index+1, dp ),helper(houses, index + 2,dp)+ houses[index]);
        
        
    }
}