class Solution {
    public String kthDistinct(String[] arr, int k) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        
        for (String s :  arr) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for (String s :  arr) {
            if (map.get(s) == 1)  {
                k--;
                if (k == 0) return s;
            }
        }
        return "";
    }
}