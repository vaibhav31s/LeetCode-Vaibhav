class Solution {
    public int minSteps(int n) {
        if (n == 1)  return 0;
        return 1 + getMinimumSteps(1, 1, n, new int[10000]);
    }
    
    int getMinimumSteps(int screen,int clipboard, int n, int[] dp) {
        if (screen == n) return 0;
        if (screen > n) return 1000000;
        
        int a = 1 + getMinimumSteps(screen + clipboard, clipboard, n, dp);
        int b = 1000000;
        if (screen != clipboard)
            b = 1 + getMinimumSteps(screen, screen, n, dp);
        return dp[screen] = Math.min(a,b);
    }
}