class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int answer = Integer.MIN_VALUE ;
        
        
        for (int i = 0; i <= nums.length - 3; i++) {
            answer = Math.max(answer, nums[i] * nums[i + 1] * nums[i + 2]);
        }
        
        int zero = 0;
        int neg = 0;
        int pos = 0;
        
        for (int x : nums) {
            if (x < 0) neg++;
            if (x > 0) pos++;
            if (x == 0) zero++;
        }
        // System.out.println(zero + " " + neg + " " + pos);
        if (zero > nums.length - 3) return 0;

        if (zero == 0 && neg == 0) {
            return answer;
        }
        
        if (zero == 0 && pos == 0) {
            return nums[nums.length - 2] * nums[nums.length - 1] * nums[nums.length - 3];
        }
        int twoneg = nums[0] * nums[1] * nums[nums.length - 1];
        int second = nums[nums.length -1] * nums[nums.length -2] * nums[0];
       
        
        
        return Math.max(twoneg, Math.max(answer, second));
    }
}