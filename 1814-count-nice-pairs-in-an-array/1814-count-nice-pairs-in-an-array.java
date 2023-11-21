class Solution {
    public static int mod = 1000000007;

    public int countNicePairs(int[] nums) {
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i] - rev(nums[i]);
        }
        
        Map<Integer, Integer> dic = new HashMap();
        long ans = 0;
        for (int num : arr) {
            ans = (ans + dic.getOrDefault(num, 0)) % mod;
            dic.put(num, dic.getOrDefault(num, 0) + 1);
        }
        
        return (int)ans;
    }
    
    boolean isGood(int[] nums, int i, int j) {
        return nums[i] + rev(nums[j]) == nums[j] + rev(nums[i]);
    }
    
    int rev(int i) {
        int no = 0;
        while (i > 0) {
            no *= 10;
            no += (i % 10);
            i /= 10;
        }
        return no;
    }
}