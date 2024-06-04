public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        
        int[] bits = new int[32];
        for (int i= 0; i< 32; i++) {
             bits[i] =  (n & (1 << i)) == 0 ? 0 : 1;
        }
        
        for (int start = 0, end = 31; start <= end; start++, end--) {
            int temp = bits[start];
            bits[start] = bits[end];
            bits[end] = temp;
        }
        int answer = 0;
        for (int i = 0; i < bits.length; i++) {
            if (bits[i] == 1) {
                answer |= 1 << i;
            }
        }
        return answer;
    }
}