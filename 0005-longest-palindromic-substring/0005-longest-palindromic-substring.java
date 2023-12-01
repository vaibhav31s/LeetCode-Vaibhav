class Solution {
    String answer = "";
    public String longestPalindrome(String s) {
        int[][] dp = new int[s.length() + 1][s.length() + 1];
        answer = s.charAt(0) + "";
        // for(int[] x : dp) Arrays.fill(x, -1);
        int len =  go(s, 0, s.length() - 1, dp);
        // System.out.println(len);
        return answer;
    }
    int go(String s, int start, int end,int[][] dp) {
        if(start > end) return 0;
        if(start == end) return 1;
        if(dp[start][end] != 0) return dp[start][end];
        if(s.charAt(start) == s.charAt(end)) {
            int a = 2 + go(s, start + 1, end - 1, dp);
            
            
            if(a == end - start + 1) {
                // System.out.println( s.substring(start, end));
                if(answer.length() <= end - start) 
                    
                 answer = s.substring(start, end + 1);
                return dp[start][end] = a;
                
            }
                
        }
         return dp[start][end] =  Math.max(go(s, start, end - 1, dp), Math.max(go(s, start + 1, end -1, dp), go(s, start + 1, end , dp)));
    }
                                                  
            
           
    
}