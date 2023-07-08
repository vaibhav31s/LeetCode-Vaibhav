class Solution {
    public int removeDuplicates(int[] nums) {
        int curr = nums[0];
        int i = 1, j = 1;
        int count = 1;
        while(j < nums.length) {
            while(j < nums.length && curr == nums[j]) {
                j++;
            }
            if(j == nums.length) {
                return count;
            }
            swap(nums, i, j);
            count++;
            curr  = nums[i];
            i++;
            j++;
        }
        return count;
        
    }
    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}