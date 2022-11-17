class Solution {
    
    HashMap<String, Integer> map = new HashMap<>();
    public int maximumScore(int[] nums, int[] multipliers) {
        int[][] dp = new int[ multipliers.length + 1][ nums.length + 1];
        
        return helper(nums, multipliers, 0,0,nums.length-1,dp);
    }
    
    int helper(int[] nums, int[] mul, int index, int nstart, int nend,int[][] dp){
        
        if(nstart > nend) return 0;
        if(index >= mul.length) return 0;
        
        String key = index + "," + nstart +"," + nend;
        if(map.containsKey(key)) return map.get(key);
        int left = helper(nums, mul, index+1, nstart + 1, nend,dp) +  (mul[index] * nums[nstart]);
        int right =  helper(nums, mul, index + 1, nstart, nend - 1,dp) +  (mul[index] * nums[nend]);
        
        map.put(key,Math.max(left, right));
        return Math.max(left, right);
        
    }
}