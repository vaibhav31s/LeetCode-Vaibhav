class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        char[] arr= s.toCharArray();
        dp[s.length()] = 1;
        for(int cur = s.length() - 1; cur >= 0; cur--) {
            if(arr[cur] == '0') {
                continue;
            }
        
            int totalWays =  dp[cur + 1];

            if(cur + 1 < arr.length) {
                int a = ((arr[cur] - '0') * 10 )+ (arr[cur + 1] - '0');
                // System.out.println(a);
                if(a <= 26) totalWays +=  dp[cur + 2];
            }

            dp[cur] = totalWays;
        }
        return dp[0];
    }
    
    int go(char[] arr, int cur, int[] dp) {
        if(cur == arr.length) return 1;
        if(arr[cur] == '0') return 0;
        if(dp[cur] != 0) return dp[cur];
        int totalWays =  go(arr, cur + 1, dp);
        
        if(cur + 1 < arr.length) {
            int a = ((arr[cur] - '0') * 10 )+ (arr[cur + 1] - '0');
            // System.out.println(a);
            if(a <= 26) totalWays +=  go(arr, cur + 2, dp);
        }
        
        return dp[cur] = totalWays;
        
    }
    
}


