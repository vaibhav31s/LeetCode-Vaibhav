class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, 1);
        
        for(int i = nums.length - 1; i >= 0; i--) {
            int max = dp[i];
            for(int j = i; j < nums.length; j++) {
                if(nums[j] > nums[i]) {
                    max = Math.max(1 + dp[j], max);
                    
                }
            }
            dp[i] =  max;
        }
        int answer = 0;
        for(int x : dp) answer = Math.max(x, answer);
        return answer;
        
    }
    int go(int[] nums, int cur, int last, int[] dp) {
        if(cur == nums.length) {
          
            return 0;
        }
        int answer = 0;
        if(dp[cur + 1] != -1) return dp[cur];
        for(int i = cur + 1; i < nums.length; i++) {
            int current = nums[i];
            if(current <= last) {
                answer = Math.max(go(nums,  i , current,dp), answer);
                continue;
            }
            
            answer = Math.max(1 + go(nums,  i , current,dp), answer);
        }
        return dp[cur] = answer; 
    }
}
