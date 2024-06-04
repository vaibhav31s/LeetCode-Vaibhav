class Solution {
    public int subsetXORSum(int[] nums) {
        return go(nums, 0, 0);
    }
    
    int go(int[] nums, int index, int xor) {
        if (index >= nums.length) {
            return xor;
        }
        
        int with = go(nums, index + 1,xor ^ nums[index]);
        int without = go(nums, index + 1,xor);
        
        return with + without;
    }
}