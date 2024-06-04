class Solution {
    public int minCostToMoveChips(int[] position) {
        int one = 0, zero = 0;
        for (int x : position) {
            if (x % 2 == 0) zero++;
            else one++;
        }
        if (one == 0 || zero == 0) return 0;
        return Math.min(one, zero);
    }
}