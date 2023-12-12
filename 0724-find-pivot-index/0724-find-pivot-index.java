class Solution {
    public int pivotIndex(int[] nums) {
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            prefix[i] = nums[i] + prefix[i - 1];
        }
        for(int i = 0; i < nums.length; i++) {
            int left = getSum(prefix, 0, i - 1);
            int right = getSum(prefix, i + 1, nums.length - 1);
            // System.out.println(i + " " +  left + " " + right);
            if(left == right) return i;
        }
        
        return -1;
    }
    int getSum(int[] pref, int start, int end) {
        if(end == -1) return 0;
        if(start == 0) return pref[end];
        return pref[end] - pref[start - 1];
    }
}
// 2 3 2
   // 0