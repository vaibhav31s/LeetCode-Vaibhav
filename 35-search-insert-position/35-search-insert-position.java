class Solution {
    public int searchInsert(int[] arr, int target) {
        int start = 0;
        int end = arr.length-1;
        while(start<end){
            int mid  = start + (end-start)/2;
            if(arr[mid]==target){
                return mid;
            }
            if(target>arr[mid]){
                start = mid+1;
            }else{
                end= mid;
            }


        }
        if(target>arr[end]){
            return end+1;
        }
        return end;
        
    }
    
}