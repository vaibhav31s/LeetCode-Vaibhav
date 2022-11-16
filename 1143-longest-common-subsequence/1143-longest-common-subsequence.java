class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][ text2.length()  + 1];
       return  helper(text1, text2, 0,0,dp);
    }
    
    int helper(String a, String b, int i , int j,int[][] dp){
        
        if(i == a.length()|| j == b.length()) return 0;
        if(dp[i][j] != 0) return dp[i][j];
        if(a.charAt(i) == b.charAt(j)) return 1 + (helper(a, b, i+1, j+1,dp));
        return  dp[i][j] = Math.max(helper(a, b, i + 1, j,dp),(helper(a, b, i , j + 1,dp)));
    }
}