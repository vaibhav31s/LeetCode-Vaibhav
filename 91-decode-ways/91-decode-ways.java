class Solution {
    HashMap<String,Integer> memo = new HashMap<>();
    public int numDecodings(String s) {
            int left  = dfs(s, s);
            return left ;
    }   
    int dfs(String first, String s){
            if(s.length() == 0 ) return 1;

            if(s.charAt(0) == '0' ) return 0;
            String key  = first +" " +  s;
            if(memo.containsKey(key)) return memo.get(key);
             int left = 0,right = 0;
            if(s.length() >=1){
                int num = Integer.parseInt(s.substring(0,1));
                if(num <= 26)
              left  = dfs(s.substring(0,1), s.substring(1,s.length()));
            }
            if(s.length() >=2){
                String temp = s.substring(0,2);
                 int num = Integer.valueOf(temp);
                if(num <= 26)
             right  = dfs(s.substring(0,2), s.substring(2,s.length()));
            }
        memo.put(key, left+ right);
        return memo.get(key);
    }
}