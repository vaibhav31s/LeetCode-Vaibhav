class Solution {
    List<String> answer = new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        for (String ss : wordDict) set.add(ss);
        go(s, 0, set, new ArrayList<>());
        return answer;
    }
    
    void go(String s, int index, HashSet<String> wordDict, ArrayList<String> subAnswer) {
        if (index >= s.length()) {
            StringBuilder sb = new StringBuilder();
            for (String x : subAnswer) {
                sb.append(x + " ");
            }
            if (sb.length() > 1) {
                sb.deleteCharAt(sb.length() - 1);
                answer.add(sb.toString());
            }
            
            
            return;
        } 
        
        for (int i = index + 1; i <= Math.min(s.length(), i + 10); i++) {
            String sub = s.substring(index, i);
            if (wordDict.contains(sub)) {
                subAnswer.add(sub);
                go(s, i, wordDict, subAnswer);
                subAnswer.remove(subAnswer.size() - 1);
            }
        }
    }
}