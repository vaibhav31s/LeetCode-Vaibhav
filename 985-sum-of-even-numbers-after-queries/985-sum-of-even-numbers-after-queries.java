class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        
        int[] arr = new int[queries.length];
        int evensum = 0;
        for(int x: nums){
            if(x%2==0)
                evensum+=x;
        }
        int i = 0;
        for(int[] q : queries){
            int val = q[0];
            int ind = q[1];
            int positionValue = nums[ind];
            if(positionValue%2==0){
                evensum-=positionValue;
            }
            
            positionValue += val;
            nums[ind] = positionValue;
            if(positionValue%2 == 0){
                evensum += positionValue;
            }
            arr[i++] =  evensum;
            
        }
        return arr;
        
    }
}