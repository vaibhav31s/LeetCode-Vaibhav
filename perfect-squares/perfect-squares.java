class Solution {
    public int numSquares(int n) {
        List<Integer> sqrList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i * i > n) break;
            sqrList.add(i * i);
        }
        
        if (sqrList.contains(n)) return 1;
        sqrList.sort(Collections.reverseOrder());
        
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return helper(n, sqrList, dp);
    }
    
    int helper(int sum, List<Integer> sqrList,int[] dp) {
        if (sum == 0) {
            return 0;
        }
        
        if (sum < 0) {
            return 10000;
        }
        
        
        
        if (dp[sum] != -1) {
            return dp[sum];
        }
        int min = 10000;
        for (int sqr : sqrList) {
            min = Math.min(1 + helper(sum - sqr, sqrList, dp), min);
        }
        
        return dp[sum] = min;
    }
        
}