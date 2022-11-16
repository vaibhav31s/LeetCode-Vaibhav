class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] arr = new int[10001];
        for(int x : nums) arr[x]++;
     Integer[] dp = new Integer[10001];
        return helper(arr, 0,dp);
    }
    int helper(int[] nums, int i, Integer[] dp){
        if(i >= nums.length) return 0;
        if(dp[i] != null)return dp[i];
        
    return dp[i] = Math.max(helper(nums, i +1, dp), helper(nums, i + 2, dp) +  (i*nums[i]));
    }
}