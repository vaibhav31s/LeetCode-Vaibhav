class Solution {
    public int pivotInteger(int n) {
        int totalSum = n * (n  + 1) / 2;
        int curSum = 0;
        for (int i = 1; i <= n; i++) {
            curSum += i;
            if (curSum == totalSum) return i;
            totalSum -= i;
        }
        return -1;
    }
}