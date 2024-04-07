class Solution {
    public boolean checkValidString(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        Boolean[][] dp = new Boolean[n + 1][201]; 
        dp[n][0] = true;
        for (int i = n; i >= 0; i--) {
            for (int balance = 0; balance <= 200; balance++) {
                if (i == n) {
                    dp[i][balance] = (balance == 0);
                } else {
                    boolean ans = false;
                    if (arr[i] == '*') {
                        if (balance + 1 <= 200) ans |= dp[i + 1][balance + 1];
                        if (balance - 1 >= 0) ans |= dp[i + 1][balance - 1];
                        ans |= dp[i + 1][balance];
                    } else if (arr[i] == '(') {
                        if (balance + 1 <= 200) ans |= dp[i + 1][balance + 1];
                    } else {
                        if (balance - 1 >= 0) ans |= dp[i + 1][balance - 1];
                    }
                    dp[i][balance] = ans;
                }
            }
        }

        return dp[0][0]; // balance of 0 corresponds to 100 in the array
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

