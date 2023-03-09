class Solution {
    public int chalkReplacer(int[] chalk, int kk) {
         long start = 0;
         long sum = 0;
         long k = kk;
          for(int x : chalk) sum +=x;
         long end = Ceil(k, sum);
         long pos =0;
        while(start <= end){
            long mid = (start + end)/2;
            long a = mid * sum;
            if(a  >=  k){
                pos = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }

        }
        int answer =0;
        // System.out.println(pos);
        
        long a = sum * start;
        if(a == k) return 0;
        a = sum * (start-1);
        for(int i = 0; i < chalk.length; i++){
            a += chalk[i];       
            // System.out.println(a);
            if(a > k) return i;

        }

        return answer;
          
    }
    
    static int intCeil(int a, int b) {
        if (a % b != 0) {
            return (a / b) + 1;
        } else {
            return (a / b);
        }
    }
    static long Ceil(long a, long b) {
        if (a % b != 0) {
            return (a / b) + 1;
        } else {
            return (a / b);
        }
    }
}