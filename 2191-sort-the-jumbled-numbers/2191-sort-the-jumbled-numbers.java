class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        for (int num : nums) {
            StringBuilder sb = new StringBuilder();
            for (char ch : String.valueOf(num).toCharArray()) {
                sb.append(mapping[ch - '0']);
            }
            int convertedInt = Integer.parseInt(sb.toString());
            map.putIfAbsent(convertedInt, new ArrayList<>());
            map.get(convertedInt).add(num);
        }
        int i = 0;
        for (List<Integer> val : map.values()) {
            for (int x : val) {
                nums[i++] = x;
            }    
        }
        
        return nums;
    }
}