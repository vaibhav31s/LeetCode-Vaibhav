class Solution {
    public int minimumAverageDifference(int[] nums) {
        
        if(nums.length == 1) return 0;
        long[] pref = new long[nums.length + 1];
        
        for(int i = 1; i <= nums.length; i++){
            pref[i] = nums[i-1] + pref[i-1];
        }
        
        long answer = Long.MAX_VALUE;
        
        // System.out.println(Arrays.toString(pref));
        
        int ans = -1;
        for(int i = 1; i < nums.length  ; i++){
            long left = pref[i] - pref[0];
            // System.out.println(left);
            long right = pref[nums.length] - pref[i];
                        // System.out.println(right);

            long l = i;
            long r = nums.length - i  ;
            
            long a = Math.abs((left/l) - (right/r));
                                    // System.out.println(l);
                                    // System.out.println(r);
                                    //             System.out.println(a);

if(answer > a){
    answer = a;
    ans = i;
}
            
        }
        
        
           if(answer > (pref[nums.length]) / nums.length) return nums.length - 1;
        return ans - 1;
    }
}