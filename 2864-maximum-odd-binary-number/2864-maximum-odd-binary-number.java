class Solution {
    public String maximumOddBinaryNumber(String s) {
        int one = 0;
        int zero = 0;
        for (char ch :  s.toCharArray()) {
            if (ch == '1') one++;
            else zero++;
        }
        
        StringBuilder sb = new StringBuilder();

        while (one-- > 1) 
            sb.append('1');            
        
        
        while (zero-- > 0) 
            sb.append('0');            
        
        while (one-- >= 0) 
            sb.append('1');            
        
        
        return sb.toString();
    }
}