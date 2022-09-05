class Solution {
    int countZeros = 0;
    public boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++){
            if(bsearch(arr[i]*2,i, 0, arr.length-1,arr)) return true;
        }
        return false;
    }
    boolean bsearch(int target, int i, int start, int end, int[] arr){
                if(target == 0){
                    countZeros++;
                    if(countZeros == 2){
                        return true;
                    }
                    return false;
                }
            while(start <= end){
                int mid = start + (end - start )/2;
              
                if(target == arr[mid]) return true;
                if(target > arr[mid]){
                    start  = mid + 1;
                }else end = mid - 1;
            }
        return false;
    }
}