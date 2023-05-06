class Solution {
    public int numSubseq(int[] nums, int target) {
        int mod = 1000000007;
        Arrays.sort(nums);
        long answer = 0;
        
        for(int i = 0; i < nums.length; i++){
            // int rightMost = Arrays.binarySearch(nums, target-nums[i]);
            int a = rightMost(nums, target - nums[i]);
            // System.out.println(a);
            if(a-i >= 0)
           answer = ( answer + power(2,a -  i, mod) ) % mod;
            
        }
        
        
        
        return (int) answer;
    }
    public static long power(long x, long y, long p) {
        //0^0 = 1
        long res = 1L;
        x = x % p;
        while (y > 0) {
            if ((y & 1) == 1)
                res = (res * x) % p;
            y >>= 1;
            x = (x * x) % p;
        }
        return res;
    }
    
    public int rightMost(int[] nums, int target){
        int start = 0;
        int end = nums.length-1; 
        int answer = -1;
        while(start <= end){
            int mid = start + (end -start)/2;
            if(nums[mid] <= target){
                answer = mid;
                start = mid + 1;
            }else end = mid -1;
        }
        return answer;
    }
    
}



