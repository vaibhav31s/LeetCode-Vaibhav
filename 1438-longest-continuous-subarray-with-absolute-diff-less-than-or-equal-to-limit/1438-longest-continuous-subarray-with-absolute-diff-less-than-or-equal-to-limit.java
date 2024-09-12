class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int start = 0;
        int end = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int max = 1;
        while (start <= end && end < nums.length) {
            if (start == end) {
                map.put(nums[start], map.getOrDefault(nums[start], 0) + 1);
                end++;
            } else if (map.lastKey() - map.firstKey() <= limit) {
                max = Math.max(max, end - start);
                map.put(nums[end], map.getOrDefault(nums[end], 0) + 1);
                end++;
            }  else {
                map.put(nums[start], map.getOrDefault(nums[start], 0) - 1);
                if (map.get(nums[start]) == 0) {
                    map.remove(nums[start]);
                }
                start++;
            }
            if (map.lastKey() - map.firstKey() <= limit) {
                max = Math.max(max, end - start);
            }
        }
        
        return max;
    }
}