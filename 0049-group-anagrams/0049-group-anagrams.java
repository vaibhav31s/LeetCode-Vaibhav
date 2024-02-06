class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<Integer>> map = new HashMap<>();
    
        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String sort = String.valueOf(arr);
            map.putIfAbsent(sort, new ArrayList<>());
            map.get(sort).add(i);
        }
        
        List<List<String>> answer = new ArrayList<>();
        
        for (List<Integer> list :  map.values()) {
            List<String> ans = new ArrayList<>();
            for (int x :  list) {
                ans.add(strs[x]);
            }
            answer.add(ans);
        }
        
        return answer;
        
    }
}