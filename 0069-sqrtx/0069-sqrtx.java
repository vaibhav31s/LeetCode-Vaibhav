class Solution {
    public int mySqrt(int x) {
        if(x == 0) return 0;
        if(x == 1) return 1;
        int start = 1;
        int end = x;
        while(end -  start > 1) {
            long mid = start + (end - start) / 2;
            if(mid * mid <= x) {
                start = (int) mid;
            } else end = (int) mid;
        }
        
        return start;
    }
}