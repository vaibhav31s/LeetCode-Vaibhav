class Solution {
    public boolean checkValidString(String s) {
         return go(s.toCharArray(), 0, 0, new Boolean[102][202]);
    }
   boolean go(char[] arr, int i, int balance, Boolean[][] dp) {
       
        if (dp[i][balance + 100] != null ) return dp[i][balance + 100];
        if (balance < 0) return false;
       
        if (i >= arr.length) {
            if (balance == 0)  return true;
            return false;
        }
        
        boolean ans = false;
        
        if (arr[i] == '*') {
            ans |= go(arr, i + 1, balance + 1, dp);
            ans |= go(arr, i + 1, balance - 1, dp);
            ans |= go(arr, i + 1, balance, dp);
        } else if (arr[i] == '(') {
            ans |= go(arr, i + 1, balance + 1, dp);
        } else ans |= go(arr, i + 1, balance - 1, dp);
        
        return dp[i][balance + 100] = ans;
    }
    
}

