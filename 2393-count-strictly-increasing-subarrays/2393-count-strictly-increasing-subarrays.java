class Solution {
    public long countSubarrays(int[] nums) {
        long answer= 0;
        
        long last = 0;
        long count =0;
        for(int x : nums){
            if(last < x){
                last = x;
                count++;
                
            }else{
                answer += ((count)*(count+1))/2;
                count =1;
                last = x;
            }
        }
        
                answer += (count)*(count+1)/2;
        
        
        
        
        return answer;
    }
}