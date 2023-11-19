class Solution {
    public int reductionOperations(int[] nums) {
        TreeMap<Integer, Integer> tmap = new TreeMap<>();
        
        for (int x : nums) {
            tmap.put(x, tmap.getOrDefault(x, 0) + 1);
        }
        
//         TreeMap<Integer, Integer> map = new TreeMap<>();
//         int i = 1;
        
//         for (int k : tmap.keySet()) {
//             map.put(i++, tmap.get(k));
//         }
        int answer = 0;
        while (tmap.size() > 1) {
            Integer lastKey = tmap.lastKey();
            int lastVal = tmap.get(lastKey);
            tmap.pollLastEntry();
            Integer secondLastKey = tmap.lastKey();
            answer += lastVal;
            tmap.put(secondLastKey, tmap.get(secondLastKey) + lastVal);
        }
       
         // return nums.length - tmap.get(tmap.firstKey());
        return answer;
    }
}



    