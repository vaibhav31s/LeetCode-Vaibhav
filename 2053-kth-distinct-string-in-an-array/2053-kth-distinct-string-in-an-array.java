class Solution {
    public String kthDistinct(String[] arr, int k) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        
        for (String s :  arr) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for (Map.Entry<String, Integer> kv : map.entrySet()) {
            if (kv.getValue() == 1)  {
                k--;
                if (k == 0) return kv.getKey();
            }
        }
        return "";
    }
}