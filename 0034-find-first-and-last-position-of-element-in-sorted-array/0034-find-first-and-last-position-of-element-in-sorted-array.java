class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = bsmin(nums, target);
        int last = bsmax(nums, target);
        return new int[]{first, last};   
    }
    int bsmin(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int answer =  -1;
        while (start <= end) {
            int mid = start +(end - start)/2;
            if (nums[mid] == target) {
                answer = mid;
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return answer;
    }
    
    int bsmax(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int answer =  -1;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (nums[mid] == target) {
                answer = mid;
                start = mid + 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return answer;
    }
}