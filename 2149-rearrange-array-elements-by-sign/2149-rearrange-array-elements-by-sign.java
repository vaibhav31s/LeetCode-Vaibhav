class Solution {
    public int[] rearrangeArray(int[] nums) {
        Deque<Integer> neg = new LinkedList<>();
        Deque<Integer> pos = new LinkedList<>();
        
        for (int num : nums) {
            if (num < 0) {
                neg.add(num);
            } else {
                pos.add(num);
            }
        }
        
        
        for(int i = 0; i < nums.length; i += 2) {
            nums[i] = pos.pollFirst();
            nums[i + 1] = neg.pollFirst();
        }
        
        
        return nums;
    }
}