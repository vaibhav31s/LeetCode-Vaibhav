class Solution {
    public long maximumOr(int[] nums, int k) {
        int[] bits = new int[66];
        long[] arr = new long[nums.length];
        for(int i = 0; i < nums.length; i++) arr[i] = nums[i];
        
        for(long x : arr){
            long pointer = 1;
            for(int i = 0; i <=63; i++){
                pointer =  1L << i ;
                // System.out.println()
                if((x & pointer ) != 0) bits[i]++;
            }
        }
        
        long answer =0;
        
        
        for(long x :  arr){
            long pointer = 1L;
            for(int i = 0; i <=63; i++){
                pointer =  1L << i ;
                // System.out.println()
                if((x & pointer ) != 0) bits[i]--;
            }
            
           long newX = x << k;
            for(int i = 0; i <=63; i++){
                pointer =  1L << i ;
                // System.out.println()
                if((newX & pointer ) != 0) bits[i]++;
            }
            
            //bits to long
            
            long newPossibleAnswer =0;
            
            
            
            
             // System.out.println(Arrays.toString(bits));
            for(int i = 0; i < bits.length; i++){
                if(bits[i] != 0){
                    newPossibleAnswer |= 1L << i;
                }
            }
             // System.out.println(newPossibleAnswer);
            
            answer = Math.max(answer, newPossibleAnswer);
            
            for(int i = 0; i <63; i++){
                pointer =  1L << i ;
                // System.out.println()
                if((newX & pointer ) != 0) bits[i]--;
            }
            
            
             for(int i = 0; i <63; i++){
                pointer =  1L << i ;
                // System.out.println()
                if((x & pointer ) != 0) bits[i]++;
            }
            
            
        }
        
     
       
        
        return answer;
        
    }   
}