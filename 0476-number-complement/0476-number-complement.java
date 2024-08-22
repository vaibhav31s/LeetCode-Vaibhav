class Solution {
    public int findComplement(int num) {
        int ans = 0;
        int[] bits = new int[32];
        int last = 0;
        for (int i = 0; i < 32; i++) {
            int mask = 1 << i;
            bits[i] = (num & mask) == 0 ? 0 : 1;
            if (bits[i] == 1) {
                last = i;
            }
        }
        
        for (int i = 0; i <= last; i++) {
            bits[i] = bits[i] == 0 ? 1 : 0;
        }
        
        for (int i = 0; i < 32; i++) {
            if (bits[i] == 1) {
                ans |= 1 << i;
            }
        }
        return ans;
    }
}


// 010
// 010