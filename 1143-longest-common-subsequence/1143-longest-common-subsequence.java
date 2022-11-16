class Solution {
    public int longestCommonSubsequence(String a, String b) {
        int[][] dp = new int[a.length() + 1][ b.length()  + 1];
        
        dp[a.length()][b.length()] = 0;
        
        for(int i  = a.length() - 1; i >= 0; i--){
            for(int j = b.length() - 1; j >= 0 ; j--){
                if(a.charAt(i) == b.charAt(j)){
                    dp[i][j] = 1 + dp[i+1][j+1];
                }else{
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }
        
        
       return dp[0][0];
    }
    
    int helper(String a, String b, int i , int j,int[][] dp){
        
        if(i == a.length()|| j == b.length()) return 0;
        if(dp[i][j] != 0) return dp[i][j];
        if(a.charAt(i) == b.charAt(j)) return 1 + (helper(a, b, i+1, j+1,dp));
        return  dp[i][j] = Math.max(helper(a, b, i + 1, j,dp),(helper(a, b, i , j + 1,dp)));
    }
}