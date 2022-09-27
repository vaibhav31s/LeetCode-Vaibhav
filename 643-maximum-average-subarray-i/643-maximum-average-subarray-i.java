class Solution {
    public double findMaxAverage(int[] nums, int k) {       
        int[] prefix = new int[nums.length+1];
        
        for(int i=0; i < nums.length; i++){
            prefix[i+1] = prefix[i] + nums[i];
        }
        double answer =-1000000;
        for(int i =0; i <= nums.length-k; i++){
            double dif = prefix[i+k] - prefix[i];
            
            answer = Math.max(answer, dif/k);
        }
        return answer;
    }
}