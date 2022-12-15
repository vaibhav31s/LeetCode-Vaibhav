class Solution {
    public int longestCommonSubsequence(String a, String b) {
        Integer[][] dp = new Integer[a.length() + 1][b.length() + 1];
        return helper(a.toCharArray(), b.toCharArray(),0,0,dp);
    }
    int helper(char[] a, char[] b, int i, int j,Integer[][] dp){
        if(i >= a.length || j >= b.length ) return 0;
        if(dp[i][j] != null) return dp[i][j];
        if(a[i] ==  b[j]){
            return dp[i][j] =  1 +  helper(a, b, i + 1, j + 1,dp);
        }
        return dp[i][j]=  Math.max(helper(a, b, i + 1, j,dp ),helper(a, b, i , j + 1,dp)) ;  
        
    }
}