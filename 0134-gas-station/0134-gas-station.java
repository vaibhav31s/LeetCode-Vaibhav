class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] abs = new int[gas.length];
        int max = Integer.MAX_VALUE;
        int index =0;
        for(int i = 0; i < gas.length; i++){
                abs[i] =  (gas[i] - cost[i]);
                
            
        }
        long answer = 0;
        long curTank = 0;
        for(int i = 0; i < abs.length; i++){
          
            
            answer += abs[i];
            curTank += abs[i];

            
            if (curTank < 0) {
              index = i +1;
              curTank = 0;
            }
        }
        
        
        
        System.out.println(Arrays.toString(abs));
        
        System.out.println(answer);
      if(answer >=0) return index;
        
        return -1;
    }
}