class Solution {
    public int nthMagicalNumber(int n, int c, int d) {
        
        int a= Math.min(c, d);
        int b= Math.max(c, d);
        long start = 1;
        long end = Long.MAX_VALUE;
        
        long lcm = lcm(a, b);
        
        long answer = 0;
        while (start <= end) {
            long mid = start + (end - start) / 2;
            long totalA = mid / a;
            long totalB = mid / b;
            long totalBoth = mid / lcm ;
            long total = totalA + totalB - totalBoth;
            
            // System.out.println(mid + " " + total);
           
            if (total >= n) {
                end = mid - 1;answer = mid;
            } else {
                start = mid + 1;
            }
        }
        
        return (int) (answer % ((long)1e9+7));
    }
    
    long gcd(long a, long b) {
        if (a > b)
                    a = (a + b) - (b = a);
        if (a == 0L)
                    return b;
        return gcd(b % a, a);
        
    }
    long lcm(long a, long b) 
    {
        return a * b / gcd(a,b);
    }
}

// 2 3 4 6 8 9 10

// 2 4 6 8 10 12 14
// 3 6 9 12 15 18 21