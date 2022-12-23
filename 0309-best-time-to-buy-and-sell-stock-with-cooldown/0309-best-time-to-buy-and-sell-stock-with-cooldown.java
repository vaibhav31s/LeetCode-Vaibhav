class Solution {
    // int[][] dp = new int[]
    // int max =0;
    public int maxProfit(int[] prices) {
    HashMap<String , Integer> dp = new HashMap<>();
        
      int max= -1;
        // for(int i = 0; i < prices.length; i++){
        int a = helper(prices,0,0,false, 0,new HashMap<>());
        // max= Math.max(a, max);
        
        return a;
      
    }
    
    int helper(int[] prices, int day,int sum, boolean buy, int last,  HashMap<String , Integer> dp){ 
        String key = day + ","+( buy ? 1 : 0) ;
       int max = last;
         if(dp.containsKey(key)) return dp.get(key);
        if(day >= prices.length){
         
        return 0;
        }
        //buy
        int b = -1;
        int a = -1;
        if(!buy){
                
              a = helper(prices, day + 1  , sum , !buy, prices[day],dp)-prices[day];
              b = helper(prices, day + 1  , sum ,  buy, 0,dp);
            
        }
        else{           
               a =   helper(prices, day + 2, sum , !buy, 0,dp)  +prices[day];
               b =  helper(prices, day  + 1, sum , buy, last,dp);
                       
        }
            
        
            dp.put(key,Math.max(a,b));

            return Math.max(a,b);
        
    }
}