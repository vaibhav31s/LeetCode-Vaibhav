class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean first =  true;
        boolean second = true;
        int last = nums[0];
        for (int x :  nums) {
            if(last < x) {
                first = false;
            }  
            last = x;
        }
        
        last = nums[0];
        for (int x :  nums) {
            if(last > x) {
                second = false;
            }  
            last = x;
        }
        
        if(first || second) return true;
        
        return false;
    }
    
}