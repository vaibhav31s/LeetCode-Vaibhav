class Solution {
    HashMap<Integer,Boolean > map = new HashMap<>();
    public boolean isValidPalindrome(String s, int k) {
     int[][] dp = new int[s.length()][s.length()];
        for (int j = 1; j < s.length(); j++) {
            int row = 0;
            int col = j;
            while (col < s.length()) {
                if (s.charAt(col) == s.charAt(col - j)) {
                    dp[row][col] = dp[row + 1][col - 1];
                } else {
                    dp[row][col] = Math.min(dp[row][col - 1], dp[row + 1][col]) + 1;
                }
                row++;
                col++;
            }

        }
        return dp[0][s.length() - 1] <= k;
    }
}