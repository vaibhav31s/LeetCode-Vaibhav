class Solution {
    public int maximum69Number (int num) {
        int last = 10;
        int len = (int) (Math.log10(num) + 1);
        int a = len;
        int l = 0;
        int n = num;
        while(num  > 0){
            int rem = num % 10;
            if(rem == 6) l = len;
            len--;
            num/=10;
        }
       if(l == 0) return n; 
        int b =(int)( Math.pow(10,a -l));
        
        return n + (3*b);
    }
}