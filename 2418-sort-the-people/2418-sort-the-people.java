class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        TreeMap<Integer, String> map = new TreeMap<>(Collections.reverseOrder());
        
        for (int i = 0; i < names.length; i++) {
            int height = heights[i];
            String name = names[i];
            map.put(height, name);
        }
        
        int i = 0;
        for (Map.Entry<Integer, String> kv : map.entrySet()) {
            names[i++] = kv.getValue();
        }
        
        return names;
    }
}