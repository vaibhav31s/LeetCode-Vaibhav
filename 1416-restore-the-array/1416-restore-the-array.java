class Solution {
   int mod = 1000000007;
    public int numberOfArrays(String s, int k) {
        
        
        // return getLen(Integer.MAX_VALUE);
        return go(s,0, k, new int[1000000]);
    }
    
     int go(String s, int last, int k, int[] dp ){
        if(s.length()   <= last  ) {
//            out.println(list);
            return 1;
        }
        if(dp[last ] != 0 ) return dp[last];
        if(s.charAt(last) == '0') return  0;
        long  count =0;
        for(int j = 1; j < 10; j++){
            if(last + j >  s.length()) break;
            String curr = s.substring(last, last+j);

            int cur = Integer.parseInt(curr);

            if(cur > k) break;

            count += go(s, last + j   , k, dp) % mod;



        }
        return dp[last] = (int) (count % mod);

    }
}


// 1 to k
// no leading zeros in the array