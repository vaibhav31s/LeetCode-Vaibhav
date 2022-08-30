class Solution {
    public int arrangeCoins(int n) {
        int count =0;
        if(n ==  1 ){
            return n;
        }
        for(int i = 1; i <= n ; i++){
            
            n -= i;
            if(n < 0){
                break;
            }
            count++;
            
        }
        return count;
    }
}