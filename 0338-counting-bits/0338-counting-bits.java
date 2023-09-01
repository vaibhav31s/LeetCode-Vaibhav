class Solution {
    public int[] countBits(int n) {
        int[] bits = new int[n+1];
        for(int i = 0; i <= n; i++) {
            bits[i] = getBits(i);
        }
    return bits;
    }
    
    int getBits( int x) {
        int mask = 1;
        int count = 0;
        for(int i = 0; i < 32; i++) {
            count += ((x & mask) != 0) ? 1 : 0; 
            mask <<= 1;
        }
        
        return count;
        
    }
}