class Solution {
    public int findMin(int[] nums) { 
        int pivotPoint = pivot(nums);
        if(pivotPoint == -1 ) return nums[0];
        return nums[pivotPoint+1];
    }
    int pivot(int[] nums){
        int start = 0;
        int end = nums.length-1;
        while(start <= end){
           
            int mid = (start + end)/2;
            if(mid < end && nums[mid] > nums[mid+1]){
                return mid;
            }
            if(mid > start && nums[mid] < nums[mid-1]){
                return mid-1;
            }

            if(nums[mid] > nums[end]){
                start = mid +1;
            }else{
                end = mid-1;
            }
        }

        return -1;
    }
}