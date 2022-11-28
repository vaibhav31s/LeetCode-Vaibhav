class Solution {
    public int jump(int[] nums) {
        Integer[] dp = new Integer[nums.length + 1];
        return dfs(nums, 0,dp);
    }
    
    int dfs(int[] nums, int index, Integer[] dp){
        // int len = nums.length;
        if(index == nums.length - 1 ) return 0;
        if(dp[index] != null) return dp[index];
        int max = Math.min(nums.length - 1, index + nums[index]);
        
        int min = nums.length;
        for(int i = max; i > index; i--){
            min = Math.min(1 + dfs(nums, i, dp),min);
        } 
        
        
        return dp[index] = min;
    }
}