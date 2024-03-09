class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> dynamicList = new ArrayList<>();
        List<List<Integer>> answer = new ArrayList<>();
        
        go(answer, dynamicList, nums, 0, new StringBuilder());
        
        return answer;
    }
    void go(List<List<Integer>> answer, List<Integer> dynamicList, int[] nums, int index, StringBuilder sb) {
        
        answer.add(new ArrayList<>(dynamicList));
        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1])  continue;
            dynamicList.add(nums[i]);
            go(answer, dynamicList, nums, i + 1, sb);
            dynamicList.remove(dynamicList.size() - 1);
        }
    }
}