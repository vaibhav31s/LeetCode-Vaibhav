class Solution {
    public int[][] insert(int[][] intervals, int[] nI) {
       
        Stack<int[]> stack = new Stack<>();
        
        for(int i = intervals.length-1; i >=0; i--){
            stack.add(intervals[i]);
        }
        ArrayList<int[]> answer = new ArrayList<>();
     
        while(!stack.isEmpty()){
            
            
            if(isOverlap(nI, stack.peek())){
                merge(nI, stack.pop());
                
            }else{
                answer.add(stack.pop());
            }
            
        }
        answer.add(nI)
            ;
        Collections.sort(answer,(a,b)->{
            return Integer.compare(a[0],b[0]);
        });
        
        
        int j = 0;
        
        // System.out.println(Arrays.toString(nI));
        int[][] ans = new int[answer.size()][2];
        for(int[] x : answer){
          
                ans[j++] = x;
            
        }
        return ans;
    }
    
    boolean isOverlap(int[] first, int[] sec){
        if(first[1] >=  sec[0] && first[1] <= sec[1]){
            return true;
        }
        
         if(sec[1] >=  first[0] && sec[1] <= first[1]){
            return true;
        }
        
        return false;
    }
    
    void merge(int[] first, int[] sec){
        int min= Math.min(first[0],sec[0]);
        int max = Math.max(first[1],sec[1]);
        first[0] = min;
        first[1] = max;
    
    }
}