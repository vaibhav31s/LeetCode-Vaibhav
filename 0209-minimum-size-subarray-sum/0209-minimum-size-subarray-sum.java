class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 1;
        ArrayList<Long> pref = new ArrayList<>();
        long sum = 0;
        pref.add(0L);
        for(int x : nums){
            sum+=x;
            pref.add(sum);
        }
        System.out.println(pref);
        int end = nums.length;
        int ans = 0;
        while(start <= end){
            int mid = start + (end -start)/2;
            long max = 0;
            for(int i = 0; i <= nums.length - mid; i++){
                long a = pref.get(i+mid) - pref.get(i);
                max = Math.max(a, max);
            }
            
            if(max >=  target){
                end = mid-1;
                ans = mid;
            }else start = mid + 1;
        }
        return ans;
    }
}