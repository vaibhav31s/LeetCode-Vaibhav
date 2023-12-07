class Solution {
    public String largestOddNumber(String num) {
        int p1 = -1;
        for (int i = num.length() - 1; i >= 0; i--) {
            int cur = num.charAt(i) - '0';
            if (cur % 2 == 1) {
                p1 = i;
                break;
            }
        }
        
        if(p1 == -1) return "";
        return num.substring(0, p1 + 1);
    }
}