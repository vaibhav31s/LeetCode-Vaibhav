class Solution {
    private static final int MAX_NUM = 5000001;
    private static final  boolean[] prime = new boolean[MAX_NUM];
    private static boolean isDone = false;
    public int countPrimes(int n) {
        if (!isDone) {
            for (int i = 2; i < MAX_NUM; i++) {
                if (prime[i]) continue;
                for (int j = i + i; j < MAX_NUM; j += i) {
                    if (!prime[j]) {
                        prime[j] = true;
                    }
                }
            } 
            isDone = true;
        }
        
        
        int count = 0;
        for (int i = 2; i < n; i++) if (!prime[i]) count++; 
        return count;
    }
}