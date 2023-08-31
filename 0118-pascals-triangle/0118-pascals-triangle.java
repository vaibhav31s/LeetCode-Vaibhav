class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answer = new ArrayList<>();
        
        answer.add(new ArrayList<>());
        answer.get(0).add(1);
        int last = 0;
        
        for (int i = 0; i < numRows - 1; i++) {
            List<Integer> level = new ArrayList<>();
            level.add(1);
            List<Integer> prevLevel = answer.get(i);
            for(int j = 0; j < prevLevel.size() - 1; j++) {
                level.add(prevLevel.get(j) + prevLevel.get(j+1));
            }
            level.add(1);
            answer.add(level);
        }
        
    
        return answer;
    }
}