public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int no) {
        int count= 0;
      for(int  i = 0; i < 32; i++){
          int a = no&1;
          if( a == 1) count++;
          no >>=1;
      }
        
        return count;
    }
}