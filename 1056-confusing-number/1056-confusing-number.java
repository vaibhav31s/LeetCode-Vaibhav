class Solution {
    public boolean confusingNumber(int n) {
        int a = n;
        int b = 0;
        while(a > 0){
            int last = a % 10;
            
            if(last == 8 ||  last == 6 ||  last ==0 || last == 1 || last == 9){}
                else return false;
            a/=10;
            b *=10;
            if(last == 6) last  = 9;
            else
            if(last == 9) last = 6;
            b+=last;
        }
        // System.out.println(b);
    return n != b;
    }
    
}