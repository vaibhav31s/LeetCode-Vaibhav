class Solution {
    int answer = 0;
    public int subsetXORSum(int[] nums) {
        go(nums, 0, new ArrayList<>());
        return answer;
    }
    
    void go(int[] nums, int index, List<Integer> list) {
        if (index >= nums.length) {
            int xor = 0;
            for(int x : list) {
                xor ^= x;
            }
            answer += xor;
            return;
        }
        list.add(nums[index]);
        go(nums, index + 1,list);
        list.remove(list.size() - 1);
        
        go(nums, index + 1,list);
    }
}