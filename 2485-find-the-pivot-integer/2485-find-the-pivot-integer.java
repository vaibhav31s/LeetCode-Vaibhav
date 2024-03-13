class Solution {
    public int pivotInteger(int n) {
        int totalSum = n * (n  + 1) / 2;
        int desiredX= (int) Math.sqrt(totalSum);
        if (desiredX * desiredX == totalSum) return desiredX;
        return -1;
    }
}