class Solution {
    public int rob(int[] nums) {
         Integer[] dp = new Integer[nums.length];
        Integer[] dp1 = new Integer[nums.length];
        
        
        int first = helper(nums,0,dp);
        int second = helper(nums, 1, dp1);
        
        return Math.max(first, second);
        
    }
    
    int helper(int[] nums, int index, Integer[] dp){
        if(index >= nums.length) return 0;
        
        if(dp[index] != null) return dp[index];
        int max = 0;
        for(int i = index + 2; i < nums.length; i++){
            int a = helper(nums, i, dp);
            max = Math.max(max, a);
        }
        
        return dp[index]  = max + nums[index];
    }
    
}