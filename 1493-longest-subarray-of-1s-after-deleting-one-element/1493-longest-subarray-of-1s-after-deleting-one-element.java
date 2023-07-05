class Solution {
    public int longestSubarray(int[] nums) {
        int zero = 0;
        
        int start =0;
        int end = 0;
        int max = 0;
        int z = 0;
        while(end < nums.length){
            while(zero <= 1 && end < nums.length){
                if(nums[end] == 0) {zero++; z++;}
                end++;
            }
            max = Math.max(end - start-2,max);
            while(zero >= 2 && start < end){
                if(nums[start] == 0) {zero--;}
                start++;
            }
            max = Math.max(end - start-1,max);
            
        }
        
        
        return max;
    }
}

// 0 4 7
// 0-4-1 = 3
// 7-4-1 = 2


// // 0 1 1 1  0 1  1 0 1
// // 0 3 0 2 0 1