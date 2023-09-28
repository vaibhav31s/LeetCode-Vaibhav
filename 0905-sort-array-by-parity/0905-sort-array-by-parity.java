class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int p1 = 0;
        int p2 = nums.length - 1;
        while(p1 < p2 && p1 < nums.length) {
            int first = nums[p1];
            if((first & 1) == 0) {
                p1++;
            } else {
                while(p2 > 0 && p1 < p2 && nums[p2] % 2 == 1) {
                    p2--;
                }
                swap(nums, p1, p2);
                p1++;
                
                if(p1 > p2) return nums;
                
            }
        }
        
        return nums;
    }
    void swap(int[] nums, int p1, int p2) {
        int temp = nums[p2];
        nums[p2] = nums[p1];
        nums[p1] = temp;
    }
}
