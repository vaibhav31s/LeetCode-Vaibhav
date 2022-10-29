class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
         
        int max = 0;
        int start = 0;
        int zeroes = 0;
        
        for(int i = 0; i < nums.length; i++){
            
            if(nums[i] == 0)
                zeroes++;
            
            while(zeroes == 2){
                if(nums[start] == 0)
                    zeroes--;
                start++;
            }
            
            max = Math.max(max, i - start + 1);
            
        }
        
        return max;
        
    }
}