class Solution {
    public void wiggleSort(int[] nums) {
        int a = 0;
        int b = 1;
        boolean flag=  false;
        while(a < nums.length && b < nums.length){
            if(flag){// if(a is greater swap with b);
                 if(nums[a] < nums[b]) swap(a, b, nums);
            }else{
                if(nums[a] > nums[b]) swap(a, b, nums);
                
            }
            flag = !flag;
            
            a++;
            b++;
        }
    }
    void swap(int a, int b,int[] nums){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
        
    }
}