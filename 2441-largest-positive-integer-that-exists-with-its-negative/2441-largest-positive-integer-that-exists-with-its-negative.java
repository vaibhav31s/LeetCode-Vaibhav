class Solution {
    public int findMaxK(int[] nums) {
        boolean[] pos = new boolean[1001];
        boolean[] neg = new boolean[1001];
        for (int x : nums) {
            if (x < 0) {
                neg[Math.abs(x)] = true;
            } else {
                pos[x] = true;
            }
        }
        
        for (int i = 1000; i >= 0; i--) {
            if (pos[i] && neg[i]) {
                return i;
            }
        }
        
        return -1;
    }
}

