class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long total = totalTrips;
        long start = 0;
        long end = 0;
        for(int x : time) {
            end = Math.max(x , end);
        }
        end *= totalTrips;
        long answer = end;
        while(start <= end){
            long mid = start + (end - start)/2;
            long a = 0;
            for(int x : time){
                a += (mid/x);
            }
            String aa = String.valueOf(a);
            String bb = String.valueOf(totalTrips);
          
            if(a >= totalTrips){
                
                end = mid-1;
            }else start = mid+1;
            
            
        }
        
        // for(long i = 1; i < end; i++) {
        //     long a = 0;
        //     for(int x : time){
        //         a += i/x;
        //     }System.out.println(i + " " + a);
        // }
        
        return start;
    }
}