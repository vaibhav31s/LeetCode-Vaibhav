class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        int[] map = new int[201];
        int max = 0;
        for(int x : nums) {
            map[x]++;
            max = Math.max(max, map[x]);
        }
        
        List<List<Integer>> answer = new ArrayList<>();
    
        while(max-- > 0) {
            List<Integer> ans = new ArrayList<>();
            for(int j = 1; j < 201; j++){
                if(map[j] > 0) ans.add(j);
                map[j]--;
            }
            answer.add(ans);
        }
        
        return answer;
    }
}