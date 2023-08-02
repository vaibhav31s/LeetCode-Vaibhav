class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        helper(nums, visited, 0, new ArrayList<>(),  answer );
        return answer;
    }
    
    void helper(int[] nums, boolean[] visited, int index, List<Integer> list, List<List<Integer>> answer){
        if(list.size() == nums.length){
            answer.add(new ArrayList<>(list));
            return;
        }
        
        for(int i = 0 ; i < nums.length; i++){
            if(!visited[i]){
                visited[i] = true;
                list.add(nums[i]);
                helper(nums, visited, i, list, answer);
                list.remove(list.size()-1);
                visited[i] = false;
            }
        }
        
        
    }
}