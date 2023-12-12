class Solution {
    public int sumOddLengthSubarrays(int[] nums) {
        int answer = 0;
        for(int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int righ = nums.length - i;
            int total = left * righ;
            answer += nums[i] *( (total + 1) / 2);
        }
        return answer;
    }
}
