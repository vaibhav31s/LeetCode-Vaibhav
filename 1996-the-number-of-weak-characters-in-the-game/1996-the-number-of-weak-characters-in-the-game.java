class Solution {
    public int numberOfWeakCharacters(int[][] p) {
               Arrays.sort(p, (a, b) -> (a[0] == b[0]) ? (b[1] - a[1]) : a[0] - b[0]);
   
        int count =0;
      
            int weakCharacters = 0;
        int maxDefense = 0;
        for (int i = p.length - 1; i >= 0; i--) {
            
            if (p[i][1] < maxDefense) {
                weakCharacters++;
            }
            maxDefense = Math.max(maxDefense, p[i][1]);
        }

        
        return weakCharacters;
    }
}