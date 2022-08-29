class Solution {
    public int mySqrt(int x) {
        if( x == 0 || x == 1) return x;
        
        long start = 1;
        int possible = -1;
        long end = x/2;
        while(start <= end){
            long mid = (start + end)/2;
            if((mid *mid) == (long)(x)) return (int)mid;
            if(mid * mid  > (long)(x)){
                end = mid - 1;
            }else {start =mid +1 ;
                  possible =(int) mid;}
        }
        return (int)possible;
    }
}