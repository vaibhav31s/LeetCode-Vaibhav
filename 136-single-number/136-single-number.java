class Solution {
    public int singleNumber(int[] nums) {
       int answer = 0;
        for(int x : nums){
            answer ^= x;
        }
        return answer;
    }
}