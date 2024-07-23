class Solution {
    public int[] frequencySort(int[] nums) {
        int[] freq = new int[203];
        
        for (int x : nums) 
            freq[x + 100]++;
        
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        
        for (int i =  202; i >= 0; i--) {
            int cur = i - 100;
            if (freq[i] != 0) {
                map.putIfAbsent(freq[i], new ArrayList<>());
                map.get(freq[i]).add(cur);
            }
        }
        
        int i = 0;
        
        for (Map.Entry<Integer, List<Integer>> kv : map.entrySet()) {
            int totalOccurence = kv.getKey();
            List<Integer> val = kv.getValue();
            for (int x : val) {
                for (int j = 0; j < totalOccurence; j++) {
                    nums[i++] = x;
                }
            }
        }
        
        return nums;
    }
}