class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);
      return  go(s.toCharArray(), wordDict, 0, dp);
    }
    
    boolean go(char[] arr, List<String> words, int cur, int[] dp) {
        
        if(cur > arr.length) return false;
        if(cur == arr.length) return true;
        if(dp[cur] != -1) return dp[cur] == 1 ? true :  false;
        boolean ans = false;
        outer:
        for (int str = 0; str < words.size(); str++) {
            String s = words.get(str);
            int len = s.length();
            if(cur + len > arr.length) continue;
            
            for(int i = 0; i < len; i++) {
                if(s.charAt(i) != arr[cur + i]) continue outer;
                
            }
            ans |= go(arr, words, cur + len,dp);
        }
        dp[cur] = !ans ? 0 : 1;
        return ans;
        
    }
}

