class Solution {
    public boolean judgeSquareSum(int c) {
        if (c == 0) return true;
        
        for (long b = 0; b * b <= c; b++) {
            if (isSquare(c - b * b)) return true;
        }
        
        return false;
    }
    
    boolean isSquare(long n) {
        double sr = Math.sqrt(n);
        
        return sr == (double)(int)sr;
    }
}