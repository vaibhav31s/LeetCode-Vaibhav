class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return checker(s, wordDict, 0, new Boolean[301]);
    }
    
    boolean checker(String s, List<String> wordDict, int curIndex, Boolean[] dp) {
        
        if (s.length() <= curIndex) {
            return true;
        }
        
        if (dp[curIndex] != null) {
            return dp[curIndex];
        }
        boolean ans = false;
        out:
        for (String word : wordDict) {
            if (word.charAt(0) == s.charAt(curIndex)) {
                if (curIndex + word.length() <= s.length()) {
                    String subString = s.substring(curIndex, curIndex + word.length());
                    if (subString.equals(word)) {
                        if (checker(s, wordDict, curIndex + word.length(), dp)) {
                            ans = true;
                            break out;
                        }
                    }    
                }
            }
        }
        return dp[curIndex] = ans;
    }
    
}