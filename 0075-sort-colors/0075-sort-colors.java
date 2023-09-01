class Solution {
    public void sortColors(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int i = 0;
        outer:
        while (start <= end && i <= end ) {
            int cur = nums[i];
            if(start >= i) {
                i++;
                continue;
            }
            if (cur == 0) {
               if(nums[start] == 0) {
                   start++;
                   continue outer;
               }
               swap(nums, start, i);
                start++;
            }
            i++;
        }
        i = end;
        
        outer:
        while (i >= 0 && start < end) {
            int cur = nums[i];
            if(cur == 0) break;
            if(i >= end) {
                i--;
                continue;
            }
            if (cur == 2) {
               if(nums[end] == 2) {
                   end--;
                   continue outer;
               }
               swap(nums, end, i);
                end--;
            }
            i--;
        }
    }
    
    void swap(int[] nums, int start, int i) {
        int temp  = nums[start];
        nums[start] = nums[i];
        nums[i] = temp;
    }
}