class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] answer = {-1,-1};
        
        answer[0] = binarySearchLeft(nums, 0, nums.length - 1, target);
        answer[1] = binarySearchRight(nums, 0, nums.length - 1, target);
        
        
        return answer;
    }
    int binarySearchLeft(int[] nums, int start, int end, int target){
        int psbl = -1;
        while(start <= end){
            int mid = start +(end - start)/2;
            if(nums[mid] == target){
                psbl = mid;
                end = mid - 1;
            }else
            if(nums[mid] < target)
                start = mid + 1;
            else end = mid - 1;
            
        }
        
        
        return psbl;
    }
    int binarySearchRight(int[] nums, int start, int end, int target){
        int psbl = -1;
        while(start <= end){
            int mid = start+(end - start)/2;
            if(nums[mid] == target){
                psbl = mid;
                start = mid + 1;
            }else
            if(nums[mid] < target)
                start = mid + 1;
            else end = mid - 1;
            
        }
        
        
        return psbl;
        
        
    }
    
    
}