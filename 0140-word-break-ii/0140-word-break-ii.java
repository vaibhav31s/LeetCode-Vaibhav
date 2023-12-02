class Solution {
     List<String> answer = new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);
       
        List<Integer> dq = new ArrayList<>();
        go(s.toCharArray(), wordDict, 0, dp, dq);
      return  answer;
    }
    
    void go(char[] arr, List<String> words, int cur, int[] dp, List<Integer> dq) {
        if(cur > arr.length) return ;
        
        // if(dp[cur] != -1) ret
        if(cur == arr.length) {
            // System.out.println(cur + " ");
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < dq.size() - 1; i++) {
                sb.append(words.get(dq.get(i)) + " ");
            }
            sb.append(words.get(dq.get(dq.size()-1)));
            answer.add(sb.toString());
            return;
        }
     
      
        outer:
        for (int str = 0; str < words.size(); str++) {
            
            String s = words.get(str);
            int len = s.length();
            
            
            for(int i = 0; i < len; i++) {
                if(cur + i >= arr.length) continue outer;
                if(s.charAt(i) != arr[cur + i]) continue outer;
                
            }
            dq.add(str);
             go(arr, words, cur + len,dp, dq);
            dq.remove(dq.size() - 1);
        }
        
     
        
    }
}

