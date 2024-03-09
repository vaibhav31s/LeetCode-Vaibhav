class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        for (int x : nums1) {
            if (Arrays.binarySearch(nums2, x) >= 0) return x;
        }
        
        return -1;
    }
}