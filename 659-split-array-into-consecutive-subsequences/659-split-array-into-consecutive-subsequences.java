class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> subsq = new HashMap<>();
        Map<Integer, Integer> frq = new HashMap<>();
        for(int x : nums) frq.put(x, frq.getOrDefault(x, 0)+1);
        int[] store = new int[2];
        int size = 0;

        for(int i : nums){
            if (frq.get(i) == 0) {
                continue;
            }
            
             if (subsq.getOrDefault(i - 1, 0) > 0) {
                subsq.put(i - 1, subsq.getOrDefault(i - 1, 0) - 1);
                subsq.put(i, subsq.getOrDefault(i, 0) + 1);
            } else if (frq.getOrDefault(i + 1, 0) > 0 && 
                       frq.getOrDefault(i + 2, 0) > 0) {
            
                       subsq.put(i + 2, subsq.getOrDefault(i + 2, 0) + 1);
                       frq.put(i + 1, frq.getOrDefault(i + 1, 0) - 1);
                       frq.put(i + 2, frq.getOrDefault(i + 2, 0) - 1);
            } else {

                 return false;
            }
            frq.put(i, frq.get(i)-1);
            
        }
        
        return true;
    }
}