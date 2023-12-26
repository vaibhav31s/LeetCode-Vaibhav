class Solution {
     long mod = 1000000007;
    public int numRollsToTarget(int n, int k, int target) {
        long[] lastState = new long[target + 1];
        long[] curState = new long[target + 1];
        lastState[0] = 1;
        for(int nn = 1; nn <= n; nn++) {
            
            for(int targett = 0;  targett <= target; targett++) {

                for(int i = 1; i <= k; i++) {
                    if((targett - i) < 0) break;
                    curState[targett] += lastState[targett - i];
                    curState[targett] %= mod;
                }   
             
            }
            
            for(int i= 0; i < lastState.length; i++) {
                lastState[i] = curState[i];
                curState[i] = 0;
            }
        }
       return (int) lastState[target]; 
    }
  
}