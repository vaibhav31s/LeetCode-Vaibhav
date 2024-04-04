class Solution {
    public int maxDepth(String s) {
        int max = 0;
        int opening = 0;
        for (char ch : s.toCharArray()) {
            
            if (ch == '(') {
                opening++;
                
            } else if (ch == ')') {
              opening--;
            }
           
            max = Math.max(max,opening);
          
            }
        
        
        
        return max;
    }
}