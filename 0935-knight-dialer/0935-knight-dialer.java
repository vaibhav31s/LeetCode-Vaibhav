class Solution {
    static long mod = 1000000007;
    public int knightDialer(int n) {
        int[][] canGo = {new int[]{4,6},new int[]{6, 8}, new int[]{7,9}, new int[]{4,8}, new int[]{3,9, 0}, new int[] {}, new int[]{0,1,7}, new int[]{2, 6}, new int[]{1,3}, new int[]{2,4}};
      
        long ans = 0;
        long[] lastState = new long[10];
        Arrays.fill(lastState, 1L);
        long[] currentState = new long[10];
        for (int i = 1; i < n; i++) {
            Arrays.fill(currentState, 0);
            for (int cur = 0; cur < 10; cur++) {
                for (int j = 0; j < canGo[cur].length; j++) {
                        currentState[cur] += lastState[canGo[cur][j]];
                }
                currentState[cur] %= mod;
            }
            for(int a = 0; a < 10; a++) {
                lastState[a] = currentState[a];
            }
        }
        
        for (long x :  lastState) {
            ans += x;
            ans %= mod;
        }
    
        return (int) ans;  
    }
}