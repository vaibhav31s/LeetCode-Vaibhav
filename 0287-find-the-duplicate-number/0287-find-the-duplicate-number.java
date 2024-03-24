class Solution {
    public int findDuplicate(int[] nums) {
        int i = 0;
        while(i < nums.length){
            if(i+1 == nums[i] ){
                i++;
            }else
            if(nums[i] != nums[nums[i]-1]) swap(nums,i,nums[i]-1); 
            else
            if(nums[i] == nums[nums[i]-1]) return nums[i];
            
        }
        
        return -1;
    }
    void swap(int[] nums, int i, int j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
}