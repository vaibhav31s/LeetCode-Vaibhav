class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }
    void mergeSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        
        int mid = (start + end) / 2;
        
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end); 
        mergetTwoSortedArray(nums,start, mid, mid + 1, end);
    }
    
    
    void mergetTwoSortedArray(int[] nums, int start1, int end1, int start2, int end2) {
        int s1= start1, e2 = end2;
        int[] arr = new  int[(end2 - start1) + 1];
        
        // System.out.println(start1 + " " + end1 + " " + start2 + " " + end2);
        int p = 0;
        while (start1 <= end1 && start2 <= end2) {
            int f = nums[start1];
            int s = nums[start2];
            if (f < s) {
                start1++;
                arr[p++] = f;
            } else {
                arr[p++] = s;
                start2++;
            }
        }
        
        while (start1 <= end1) {
            arr[p++] = nums[start1++];
        }
        
        while (start2 <= end2) {
            arr[p++] = nums[start2++];
        }
        
//         System.out.println(Arrays.toString(Arrays.copyOfRange(nums, start1, end2 + 1)));
        
        // System.out.println(Arrays.toString(arr));
        int pointer = 0;
        for (int i = s1; i <= e2; i++) {
            nums[i] = arr[pointer++];
        }
    }
    
    // 1 2 3 4
    // 1 4

    
}