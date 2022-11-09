class Solution {
    public int minSwaps(int[] data) {
        int one  = 0;
        for(int x : data) if(x == 1) one++;
        
        if(one == 1 ||  one == data.length ) return 0;
        
        
//         System.out.println(one);
//         System.out.println(data.length);
        int win =one;
       int curOneInWin = 0;
        int maxOneInWin = 0;
        for(int i = 0; i < data.length; i++){
            curOneInWin += data[i];
            if(i >= win){
                curOneInWin -= data[i -  win];
                
            }
            maxOneInWin = Math.max(maxOneInWin, curOneInWin);
        }
        
        
        
        
        return win - maxOneInWin;
    }
}