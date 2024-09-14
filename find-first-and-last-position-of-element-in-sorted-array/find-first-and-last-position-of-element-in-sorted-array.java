class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = getLeftIndexInSortedArray(nums, target);
        int right = getRightIndexInSortedArray(nums, target);
        
        
        if (left == -1 || right == -1) {
            return new int[] {-1, -1};
        }
        
        return new int[]{left, right};
    }
    
    int getLeftIndexInSortedArray(int[] nums, int target) {
        int ans = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                ans = mid;
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }
    
    int getRightIndexInSortedArray(int[] nums, int target) {
            int ans = -1;
            int start = 0;
            int end = nums.length - 1;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (nums[mid] == target) {
                    ans = mid;
                    start = mid + 1;
                } else if (nums[mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            return ans;
    }
}