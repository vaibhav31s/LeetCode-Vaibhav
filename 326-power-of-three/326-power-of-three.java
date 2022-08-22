class Solution {
    public boolean isPowerOfThree(int n) {
        double first = (int) (Math.log(n)/ Math.log(3));
        double second = Math.log(n)/Math.log(3);
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }
}