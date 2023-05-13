class Solution {
    int mod = 1000000007;
    public int countGoodStrings(int low, int high, int zero, int one) {
        String zeros = "";
        String ones = "";
        for(int i =0 ; i < zero; i++){
            zeros+= "0";
        }
        for(int i =0 ; i < one; i++){
            ones+= "1";
        }
        
        return  go(low, high, zero, one, 0,new HashMap<Integer,Integer>())  % mod;
        
          
    }
    int go(int low, int high, int zero, int one, int s, HashMap<Integer,Integer> set ){
        if(( s > high)) return 0;
        if(set.containsKey(s)) return set.get(s)  % mod;
        
        int getzero =  go(low, high, zero, one, s +zero, set) % mod;
        int getOne =  go(low, high, zero, one, s +one, set) % mod;
        
       if(s< low ) { set.put(s, ( getzero + getOne) % mod);}
        else
        set.put(s, (1 + getzero + getOne) % mod);
        
        return set.get(s) % mod;
        
    }
}