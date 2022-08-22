class Solution {
    public boolean isPowerOfFour(int n) {
        double first = (int) (Math.log(n)/ Math.log(4));
        double second = Math.log(n)/Math.log(4);
        return first == second;
    }
}