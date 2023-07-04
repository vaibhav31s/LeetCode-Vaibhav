class Solution {
    public int singleNumber(int[] nums) {
        int[] bits = new int[32];
        for(int number : nums){
            for(int i = 0; i < 32; i++){
                int mask = 1 << i;
               if((number & mask) != 0 ){
                     bits[i]++;
               }    
                
            }
        
        }
        
        for(int i = 0; i < 32; i++)bits[i]%=3;
        
        int answer = 0;
                 
        for(int i = 0; i < 32; i++){
            if(bits[i] >= 1){
                int mask = 1 << i;
                answer ^= mask;
            }
        }
        
        
        return answer;
    }
}

// 0 1 1
// 1 0 1
// 0 0 1 