class Solution {
    public int minSwaps(int[] data) {
        int one  = 0;
        int zero = 0;
        for(int x : data){
            if(x==1)
                one++;
            else 
                zero++;
        }
        int win = one, n = data.length;
        int size = one;
        int s = 0;
        int answer = Integer.MAX_VALUE;
        int bone = 0;
        int bzero = 0;
        for(int i = 0; i < n; i++){
            int x = data[i];
            int last = i - win;
            if(s < one){
                s++;
                if(x==1)
                    bone++;
                else 
                    bzero++;
            }else{
                answer = Math.min(bzero, answer);
                
                if(data[last]==1)
                    bone--;
                else 
                    bzero--;
                
                
                if(x==1)
                    bone++;
                else 
                    bzero++;
                
                
            }
            
            
        }
         answer = Math.min(bzero, answer);
        return answer;
    }
}