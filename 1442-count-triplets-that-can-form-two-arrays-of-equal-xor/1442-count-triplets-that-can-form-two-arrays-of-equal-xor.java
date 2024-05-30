class Solution {
    public int countTriplets(int[] arr) {
        int n =arr.length;
        int count =0;
        for(int i = 0; i < n; i++){
            for(int j = i + 1 ; j < n; j++){
                for(int k = j ; k < n; k++){
                    int a = go(arr,i, j-1);
                    int b = go(arr,j, k);
                    if(a == b) count++;
                    
                }
            }
        }
        
        
        return count;
    }
    int go(int[] arr, int i, int j){
        int ans = 0;
        for(; i <=j; i++){
            ans ^= arr[i];
        }
        return ans;
    }
}