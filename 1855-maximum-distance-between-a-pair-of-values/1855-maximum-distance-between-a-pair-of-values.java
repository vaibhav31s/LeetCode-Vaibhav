class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int max = 0;
        for(int i = 0; i < nums1.length; i++){
            int index = binarySearch(nums1[i],i, nums2.length-1, nums2);
           
            if(index == -1) continue;
            max = Math.max(Math.abs(i -  index),max);
        }
        
        return max;
    }
   int binarySearch(int target, int start, int end, int[] nums2){
        int ans = start;
        while(start <= end){
            int mid = start +(end - start)/2;
            if(target <= nums2[mid]){
                ans = mid;
                start = mid+1;
            }else end = mid-1;;
        }
        return ans;
        
    }
}