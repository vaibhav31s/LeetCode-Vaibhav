/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     // Compares the sum of arr[l..r] with the sum of arr[x..y] 
 *     // return 1 if sum(arr[l..r]) > sum(arr[x..y])
 *     // return 0 if sum(arr[l..r]) == sum(arr[x..y])
 *     // return -1 if sum(arr[l..r]) < sum(arr[x..y])
 *     public int compareSub(int l, int r, int x, int y) {}
 *
 *     // Returns the length of the array
 *     public int length() {}
 * }
 */

class Solution {
    public int getIndex(ArrayReader reader) {
     
        int left = 0;
        int right=  reader.length() - 1;
        
        while(left < right){
            int mid = (left + right)/2;
            int sum = reader.compareSub(left, (left + right)/2,(left + right + 1)/2, right);
           
            
            if(sum < 0 ){
                left =(left + right + 1)/2;
            }else{
                right = mid;
            }
        } 
        
        return left;
    }
}