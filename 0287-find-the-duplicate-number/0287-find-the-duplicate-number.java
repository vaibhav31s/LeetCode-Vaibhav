class Solution {
    public int findDuplicate(int[] nums) {
        long[] pref = new long[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            pref[i] = i * nums.length;
        }
        
        int answer = 1;
        int start = 0; 
        int end = nums.length; 
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int[] data = count(nums, mid);
            
            if (data[2] >= 2) return mid;
            
            if (data[0] >= mid) {
                end = mid - 1; 
            } else {
                answer = mid;
                start = mid + 1;
            }
            
        }
        
        
        
        return answer;
        
    }
   
    int[] count(int[] nums, int val) {
        int lesser = 0, greater = 0, equal = 0;
        for (int x :  nums ) {
            if (x < val) lesser++;
            else if (x > val) greater++;
            else equal++;
        }
        return new int[]{lesser, greater, equal};
    }
}