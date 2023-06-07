class Solution {
    public int minFlips(int a, int b, int c) {
        int mask = 1;
        int answer = 0;
        
        for(int i = 0; i < 32; i++){
            
            
            if((a & mask) != 0 && (b & mask) != 0  && (c & mask) == 0)
                    answer +=2;
            else if((a & mask) == 0 && (b & mask) == 0  && (c & mask) != 0)
                    answer += 1;
            else if(((a & mask) != 0  || (b & mask) != 0) && (c & mask) == 0) answer++;
            
                
            
                    // answer += 1;
            
            
            
            mask <<= 1;
        }
        
        return answer;
        
    }
}