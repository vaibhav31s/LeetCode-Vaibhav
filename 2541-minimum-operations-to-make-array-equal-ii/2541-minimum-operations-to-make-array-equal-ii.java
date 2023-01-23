class Solution {
    public long minOperations(int[] nums1, int[] nums2, int k) {
        int[] dif = new int[nums1.length];
        if(k == 0){ 
            for(int i = 0; i < nums1.length;i++){
                if(nums1[i] != nums2[i]) return -1;
            }
            
            return 0;}
        int c = 0;
        for(int i = 0; i < nums1.length; i++){
            dif[i] = nums1[i] -  nums2[i];
            if(dif[i] == 0)c++;
        }
            long positive= 0;
            long negetive = 0;
        int count =0;
        for(int x : dif){
            if(Math.abs(x) % k != 0) return -1;
            
            if(x > 0 ) {
                positive+= x; count++;
            }else negetive += x;
        }
        
        if(positive + negetive != 0) return -1;
        
        
        return positive / k;
        
//         PriorityQueue<Integer> pq = new PriorityQueue<>();
//         for(int x : pq ) = pq.add(x);
        
       
    }
}