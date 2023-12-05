class Solution {
    public int numberOfMatches(int n) {
        return go(n);
    }
    int go(int n) {
        if(n <= 1) return 0;
        if(n % 2 == 0) return n/2 + go(n/2);
        
        return ((n - 1) / 2 )+ go((n - 1) / 2 + 1);
    }
}