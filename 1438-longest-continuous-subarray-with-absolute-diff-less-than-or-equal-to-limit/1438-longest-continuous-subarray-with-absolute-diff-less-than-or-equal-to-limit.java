class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int start = 1;
        int end = nums.length;
        int max = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isGoodSubArray(nums, mid, limit)) {
                start = mid + 1;
                max = mid;
            } else {
                end = mid - 1;
            }
        }
        return max;
    }
    
    boolean isGoodSubArray(int[] nums, int mid, int limit) {
        TreeMap<Integer, Integer> tMap = new TreeMap<>();
        
        for (int i = 0; i < mid; i++) {
            tMap.put(nums[i], tMap.getOrDefault(nums[i], 0) + 1);
        }
        
        
       
        
        for (int i = 0; i < nums.length - mid; i++) {
            int lower = tMap.firstKey();
            int higher = tMap.lastKey();
            if (Math.abs(higher - lower) <= limit) return true;
            tMap.put(nums[i], tMap.getOrDefault(nums[i], 0) - 1);
            if (tMap.get(nums[i]) == 0) tMap.remove(nums[i]);
            tMap.put(nums[i + mid], tMap.getOrDefault(nums[i + mid], 0) + 1);
        }
        int lower = tMap.firstKey();
        int higher = tMap.lastKey();
        if (Math.abs(higher - lower) <= limit) return true;
        
        return false;
    }
}