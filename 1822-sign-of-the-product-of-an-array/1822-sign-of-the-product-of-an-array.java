class Solution {
    public int arraySign(int[] nums) {
        boolean  negative = false;
        
        for(int x : nums){
            if(x == 0) return 0;
            if(x < 0) negative = !negative;
        }
       
        return negative ? -1 : 1;
        
    }
}