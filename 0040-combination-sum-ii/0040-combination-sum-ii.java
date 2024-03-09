class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> answer = new ArrayList<>();
        go(candidates, target, 0, answer, new ArrayList<>());
        return answer;
    }
    
    void go(int[] arr, int target, int ind, List<List<Integer>> answer, List<Integer> list) {
        if (target < 0) return;
        
        if (target == 0) {
            answer.add(new ArrayList<>(list));
            return;
        }
        
        for (int i = ind; i < arr.length; i++) {
            if (i != ind && arr[i] == arr[i - 1]) continue;
            list.add(arr[i]);
            go(arr, target - arr[i], i + 1, answer, list);
            list.remove(list.size() - 1);
        }
        
    }
}