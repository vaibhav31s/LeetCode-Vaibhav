class Solution {
    public int minSwaps(int[] nums) {
        int zero = 0;
        int one = 0;
        for(int x : nums){
            if(x == 0 ) zero++;
            else one++;
        }
        
        Deque<Integer> dq = new LinkedList<>();
        for(int x : nums) dq.add(x);
        
        Deque<Integer> answer = new LinkedList<>();
        int bone = 0;
        int bzero = 0;
        int possible = 1231231;
        
        for(int i = 0; i < one; i++){
            if(nums[i] == 1)bone++;
                else bzero++;
            dq.pollFirst();
            dq.add(nums[i]);
            answer.add(nums[i]);
        }
        for(int i = one; i < nums.length; i++){
            
            dq.add(nums[i]);
        }
         // System.out.println(bzero);
        
        while(!dq.isEmpty() && !answer.isEmpty()){        
        
            int pahila = dq.pollFirst();
            int lastcha = answer.pollFirst();
            if(lastcha == 1) bone--;
            else bzero--;
              
            if(pahila == 1){
                bone++;
            }else
                bzero++;  
           
             possible = Math.min(possible, bzero);
            answer.add(pahila);
         // System.out.println(answer.size());
        }   
         possible = Math.min(possible, bzero);
         
                // possible = Math.min(possible, bzero);
            
        return possible;
    }
}