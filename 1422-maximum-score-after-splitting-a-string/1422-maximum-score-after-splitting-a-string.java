class Solution {
    public int maxScore(String s) {
        int[] prefixZero = new int[s.length()];
        int[] prefixOne = new int[s.length()];
        int[] suffixZero = new int[s.length()+1];
        int[] suffixOne = new int[s.length()+1];
        int one = 0;
        int zero = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '0') {
                zero++;
            } else {
                one++;                
            }
            prefixZero[i] = zero;
            prefixOne[i] = one;
        }
       
        
        
        int max = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            max = Math.max(prefixZero[i] + (prefixOne[s.length() - 1] - prefixOne[i]), max);
        }
        
        return max;
    }
}