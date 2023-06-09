class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        int start = lowerBound(target, nums);
        int end = upperBound(target, nums);
        
        if(start == -1 && end == -1) return false;
        
        
        return (end - start) >= (nums.length/2);
    }
    
    int lowerBound(int target, int[] nums){
        int ans = -1;
        int start = 0;
        int end = nums.length -1;
        while(start <= end){
            int mid = (start + end)/2;
            if(nums[mid] == target){
                ans = mid;
                end = mid-1;
            }else if(nums[mid] < target){
                start = mid+1;
            }else end =  mid -1;
            
        }
        return ans;
    }
    int upperBound(int target, int[] nums){
        int ans = -1;
        int start = 0;
        int end = nums.length -1;
        while(start <= end){
            int mid = (start + end)/2;
            if(nums[mid] == target){
                ans = mid;
                start = mid+1;
            }else if(nums[mid] < target){
                start = mid+1;
            }else end =  mid -1;
            
        }
        return ans;
    }
}