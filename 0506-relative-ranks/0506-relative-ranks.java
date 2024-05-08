class Solution {
    public String[] findRelativeRanks(int[] score) {
        String[] answer = new String[score.length];
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < score.length; i++) {
            map.put(score[i], i);
        }
        
        int i = 0;
        
        while (!map.isEmpty() && i <= 2) {
            int key = map.lastKey();
            if (i == 0) {
                answer[map.get(key)] = "Gold Medal";
            } else if (i == 1) {
                answer[map.get(key)] = "Silver Medal";
            } else {
                answer[map.get(key)] = "Bronze Medal";
            }
            i++;
            map.pollLastEntry();
        } 
         i++;
         while (!map.isEmpty()) {
            int key = map.lastKey();
            answer[map.get(key)] = String.valueOf(i++);
            map.pollLastEntry();
         }
        
        return answer;
    }
}