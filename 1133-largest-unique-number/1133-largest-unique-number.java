class Solution {
    public int largestUniqueNumber(int[] nums) {
        TreeMap<Integer,Integer> answer = new TreeMap<>();
        for(int x : nums) answer.put(x, answer.getOrDefault(x, 0)+1);
        
        while(!answer.isEmpty()){
            	int a = answer.lastKey();
           if(answer.pollLastEntry().getValue() == 1) return a;
        }
        
        return -1;
    }
}