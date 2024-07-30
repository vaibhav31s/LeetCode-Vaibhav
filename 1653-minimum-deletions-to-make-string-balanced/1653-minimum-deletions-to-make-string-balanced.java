class Solution {
    public int minimumDeletions(String s) {
        int countA = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'a') countA++;
        }
        
        if (countA == 0) return 0;
        
        int min = s.length();
        
        int nowA = 0, nowB = 0;
        for (int i = 1; i <= s.length(); i++) {
            int left = nowB;
            int right = countA;
            
            min = Math.min(left + right, min);
           if (s.charAt(i - 1)  == 'a') {
                countA--;
            }
            if (s.charAt(i - 1)  == 'b') {
                nowB++;
            }
            
            left = nowB;
            right = countA;
            
            min = Math.min(left + right, min);
            
        }
        
        return min;
    }
}