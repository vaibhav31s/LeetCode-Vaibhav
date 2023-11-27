class Solution {
    static long mod = 1000000007;
    public int knightDialer(int n) {
        
       
        // int[] moves = new int[]{2,2,2,2,3,0,3,2,2,2};
        int[][] canGo = {new int[]{4,6},new int[]{6, 8}, new int[]{7,9}, new int[]{4,8}, new int[]{3,9, 0}, new int[] {}, new int[]{0,1,7}, new int[]{2, 6}, new int[]{1,3}, new int[]{2,4}};
      
        int ans = 0;
        int[] lastState = new int[10];
        Arrays.fill(lastState, 1);
        for (int i = 1; i < n; i++) {
            int[] currentState = new int[10];
            for(int cur = 0; cur < 10; cur++) {
                for(int j = 0; j < canGo[cur].length; j++) {
                        currentState[cur] += lastState[canGo[cur][j]];
                        currentState[cur] %= mod;
                }
            }
             lastState = currentState;
        }
        
        // int ans = 0;
        for(int x :  lastState)  {
            ans += x;
            ans %= mod;
        }
        // System.out.println(Arrays.toString(dp[n]));
        return ans;
            
            
    }
    int go(int[][] canGo, int n, int cur, Integer[][] dp) {
        if(n == 1) return 1;
        int total = 0;
        
        if (dp[n][cur] != null) return dp[n][cur];
            // total += canGo[cur].length;
        for(int j = 0; j < canGo[cur].length; j++) {
            total += go(canGo, n - 1, canGo[cur][j], dp);
            total %= mod;
        }
        return dp[n][cur] = total;
        
        
    }
}