class Solution {
    public String destCity(List<List<String>> paths) {
        HashMap<String, String> alist = new HashMap<>();
        for(List<String> path : paths) {
            String a = path.get(0);
            String b = path.get(1);
            alist.put(a, b);
            alist.putIfAbsent(b, "");
        }
        String answer = "";
        for(String key : alist.keySet()) {
            if(alist.get(key).equals("")) {
                answer= key;
            }
        }
        
        return answer;
        
    }
}