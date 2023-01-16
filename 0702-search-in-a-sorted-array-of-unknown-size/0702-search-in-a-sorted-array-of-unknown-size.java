/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int l = 0;
        int r = 100001;
        
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(reader.get(mid) == 2147483647 ){
                r = mid  - 1;
                continue;
            }
            
            if(reader.get(mid) == target ) return mid;
            if(reader.get(mid) < target  ) {
               l = mid + 1; 
            }else r = mid- 1;
            
            
        }
        
       
        
        
        return -1;
        
    }
}