class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1 ) return nums[0];
        Integer[] dp = new Integer[10001];
        Integer[] dp1 = new Integer[10001];
        
        return Math.max(helper(nums, 0, 0, dp1),helper(nums,1, 1, dp));
    }
    int helper(int[] houses, int start, int index, Integer[] dp){
        
         if(start==0 && index==houses.length-2){
            return houses[index];
        }
        if(start==1 && index==houses.length-1){
            return houses[index];
        }
        if(start==0 && index>=houses.length-1){
            return 0;
        }
        if(start==1 && index>=houses.length){
            return 0;
        }
//         if(start == 0 && index == houses.length-1) return 0;
        
//         if(index >= houses.length) return 0;
        
        if(dp[index] != null) return dp[index];
        
        
        return  dp[index] = Math.max(helper(houses, start, index+1, dp ),helper(houses,start,  index + 2,dp)+ houses[index]);
        
   
    }
    
}