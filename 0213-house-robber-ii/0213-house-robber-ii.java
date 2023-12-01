class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        for(int i = nums.length - 1; i > 0; i--) {
            
            dp[i] += nums[i];
            int maxx = 0;
            for(int j = i + 2; j < dp.length; j++) {
                if(i == 0 && j == nums.length - 1) continue;
                maxx = Math.max(dp[j], maxx);
            }
            dp[i] += maxx;
        }
        
        int[] dp1= new int[nums.length + 1];
        
        
        for(int i = nums.length - 1; i >= 0; i--) {

                dp1[i] += nums[i];
                int maxx = 0;
                for(int j = i + 2; j < dp1.length - 2; j++) {
                    maxx = Math.max(dp1[j], maxx);
                }
                dp1[i] += maxx;
            }
        
        int max = 0;
        for(int x : nums) max = Math.max(max, x);
        for(int x : dp1) max = Math.max(max, x);
        for(int x : dp) max = Math.max(max, x);
        
        
        return Math.max(max, Math.max(dp[0], dp[1]));
    }
}

