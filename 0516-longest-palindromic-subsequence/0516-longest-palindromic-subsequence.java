class Solution {
    public int longestPalindromeSubseq(String s) {
     // return    go(s, new StringBuilder(),0, new HashMap<>());
        
        return go(s.toCharArray(), 0, s.length()-1, new HashMap<>());
    }
    
    int go(char[] s, int i, int j, HashMap<String, Integer> dp){

        if(i > j || i < 0 || j >= s.length) return 0;
        if(i==j) return 1;
        String k = i + "," +j;
        if(dp.containsKey(k)) return dp.get(k);
        if(s[i] == s[j]) return 2 + go(s, i+1, j-1, dp);
        
        dp.put(k,Math.max(go(s, i+1, j, dp),go(s, i, j-1, dp)));
        return Math.max(go(s, i+1, j, dp),go(s, i, j-1, dp));
    }
    
    
    
   //brute force wont work;
    int go(String s,StringBuilder t, int i,HashMap<String, Integer> memo){
        if(i >= s.length()){
            if(isPali(t.toString())) return t.length();
            // System.out.println(memo);
            return 0;
        }
        String k = t +","+i;
        if(memo.containsKey(k)) return memo.get(k);
        
        int pick = go(s, t.append(s.charAt(i)), i+1,memo);
        t.deleteCharAt(t.length()-1);
        int notPick = go(s, t, i+1,memo);
        memo.put(k,Math.max(pick, notPick) );
        return memo.get(k);
    }
    
    boolean isPali(String s){
        for(int i = 0, j = s.length()-1; i <= j; i++, j--){
            if(s.charAt(i)!= s.charAt(j)) return false;
        }
        return true;
    }
    
}

