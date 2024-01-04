class Solution {
    public int minOperations(int[] nums) {
        HashMap<Integer, Integer> map =new HashMap<>();
        for(int x : nums) map.put(x, map.getOrDefault(x, 0) + 1);
        int max =0;
        for(int x : map.values()) {
            if(x == 1) return -1;
            max = Math.max(max, x);               
        }
            int min = 0;
        for(int x : map.values()) {
            min += Math.ceil((double)x / 3);
        }
        return min;
    }
}
