class Solution {
    public boolean winnerOfGame(String colors) {
        int alice = 0, bob = 0, countA = 0, countB = 0;
        for(char ch : colors.toCharArray()) {
            if(ch == 'A') {
                if(countA == 0) 
                     bob += Math.max(0, countB - 2);
                
                countA++;
                countB = 0;
            } else {
                if(countB == 0) 
                    alice += Math.max(0, countA - 2);
                
                countB++;
                countA = 0;
            }
        }
        if(countA == 0)
            bob += Math.max(0, countB - 2);
        
        if(countB == 0)
            alice += Math.max(0, countA - 2);
        
        return alice > bob;
    }
}


