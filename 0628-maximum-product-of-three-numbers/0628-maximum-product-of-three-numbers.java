class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int third = nums[0] * nums[1] * nums[2];
        int forth = nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
        int first = nums[0] * nums[1] * nums[nums.length - 1];
        int second = nums[nums.length -1] * nums[nums.length -2] * nums[0];
        return Math.max(first, Math.max(third, Math.max(forth, second)));
    }
}