class Solution {
    public int countPrimes(int n) {
        boolean[] prime = new boolean[n + 1];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (prime[i]) continue;
            else count++;
            for (int j = i + i; j <= n; j += i) {
                if (!prime[j]) {
                    prime[j] = true;
                }
            }
        }
        return count;
    }
}