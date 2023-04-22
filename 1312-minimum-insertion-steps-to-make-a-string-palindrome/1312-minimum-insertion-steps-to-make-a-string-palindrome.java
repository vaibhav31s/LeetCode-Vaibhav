class Solution {
    public int minInsertions(String s) {
        return go(s.toCharArray(),0, s.length()-1, new int[500][500]);
        
    }
    int go(char[] s, int start, int end, int[][] dp){
        if(start > end){
            return 0;
        }
        if(dp[start][end] != 0) return dp[start][end];
        if(end ==start) return 0;
        if(s[start] == s[end]){
            return  go(s, start+1, end-1,dp);
        }
        int first =  go(s, start+1, end ,dp);
        int second = go(s, start, end-1 ,dp);
        
        return dp[start][end] = 1 + Math.min(first, second);
        
    }
}
