class Solution {
    
    public int rob(int[] nums) {
        Integer[] dp  = new Integer[nums.length];   
        
       return  helper(nums, 0,dp);
    }
    int helper(int[] nums, int i, Integer[] dp){
        if(i >= nums.length) return 0;
        if(dp[i] != null) return dp[i];
        return dp[i] = Math.max(helper(nums, i + 1,  dp), helper(nums, i + 2, dp) + nums[i]);
        
    }
    
    
}