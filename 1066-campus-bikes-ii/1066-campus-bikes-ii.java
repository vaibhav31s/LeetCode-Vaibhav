class Solution {
    int max = Integer.MAX_VALUE;
    public int assignBikes(int[][] workers, int[][] bikes) {
        
        boolean[] occworker = new boolean[workers.length];

        boolean[] occbike = new boolean[bikes.length];
       
          dfs(workers, 0,bikes, occbike , 0);
          
    
        return max;
    }
    
    
    
    
    void dfs(int[][] workers, int worker, int[][] bikes, boolean[] occbike,int sum){
        if(workers.length == worker){
            // System.out.println(Arrays.toString(occbike));
         // System.out.println(sum);

            max= Math.min(sum,max);
            return;
        
        }
        if(max <= sum) return;
        for(int i = 0; i < bikes.length; i++){
            if(!occbike[i]){
            
                  occbike[i] = true;
                  // dfs(workers, worker + 1,bikes, occbike,  sum + getDistance(workers[worker][0],workers[worker][1],bikes[i][0],bikes[i][1]));
                dfs(workers, worker + 1,bikes, occbike,  sum + findDistance(bikes[i],workers[worker]));
                
                
                  occbike[i] = false;
            }
        }
        
    }
    
    
    int getDistance(int x1, int y1, int x2, int y2){
        return Math.abs(x2-x1) + Math.abs(y2-y1);
    }
    int findDistance(int[] worker, int[] bike) {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }
}