class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int req = n * (n + 1) / 2;
        boolean zero = false;
        int sum = 0;
        
        for(int x : nums) {
            if(x == 0) zero = true;
            sum += x;
        }
        if (!zero) return 0;
        
        if(sum == req) return n;
        
        return req - sum;
    }
}