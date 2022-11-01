class Solution {
    public int smallestCommonElement(int[][] mat) {
        int m = mat.length;
       
        for(int x : mat[0]){
            int count = 1;
            for( int i =1; i < mat.length; i++){
                if(bs(mat[i],x)) count++;
                else break;
            }
            // System.out.println(count);
            if(count == m) return x;
        }
        
        
        
        return -1;
    }
    boolean bs(int[] nums, int target){
         int start = 0;
            int end = nums.length -1;
            while(start <= end){
                int mid = (start + end)/2;
                if(nums[mid] == target) return true;
                if(nums[mid] > target){
                    end = mid -1;
                }else{
                    start = mid +1;
                }
            }
            return false;
    }
}