class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        HashSet<String> ans = new HashSet<>();
            StringBuilder s = new StringBuilder();
        for(int i = 1; i <= 9; i++){
            s.append(i);
            backtrack(s, i, n, k,ans);
            s.deleteCharAt(s.length()-1);

        }        
    
        int[] answer = new int[ans.size()];
        int i = 0;
        for(String c : ans){
            answer[i++] = Integer.parseInt(c);
        }
        return answer;
    }
    
    void backtrack(StringBuilder s, int last, int n, int k, HashSet<String> answer){
        if(s.length() == n){
            answer.add(s.toString());
            return;
        }
        
        if((last - k) < 0 ){
        }else{
            s.append(last-k);
            backtrack(s, last-k, n, k, answer);
            s.deleteCharAt(s.length()-1);
        }
        
        if(last + k > 9){
            
        }else{
             s.append(last+k);
             backtrack(s, last+k, n, k, answer);
             s.deleteCharAt(s.length()-1);
        }
        
        
    }
        
    
}