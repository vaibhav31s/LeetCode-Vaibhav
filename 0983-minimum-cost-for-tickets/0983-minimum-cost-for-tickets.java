class Solution {
    public int mincostTickets(int[] days, int[] costs) {
         return go(days, costs, 0,0, new HashMap<>());
        
    }
    
       int go(int[] days, int[] costs, int index, int a, HashMap<Integer, Integer> dp){
        
      
                if(index >= days.length) return 0;

        if(dp.containsKey(index)) return dp.get(index);
        int first = go(days, costs, increament(days,index,1) , a+1,dp) + costs[0];
        int second = go(days, costs, increament(days,index,7) , a+7,dp)+ costs[1];
        int third = go(days, costs, increament(days,index,30) , a+30,dp)+ costs[2];
         
        dp.put(index, Math.min(first, Math.min(second, third)));
        
        return dp.get(index);
    }
    
    int increament(int[] days, int index, int delta){
        
        int d = days[index];
        d += delta;
        while(index < days.length && d > days[index]){
            index++;
        }
        
        return index;
        
    }
}