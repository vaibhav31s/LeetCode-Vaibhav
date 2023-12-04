class Solution {
    public String largestGoodInteger(String num) {
        int max = -1;
        int win = 3;
        for(int i = 0; i <= num.length() - 3; i++) {
            if(num.charAt(i) == num.charAt(i + 1) && num.charAt(i + 1) == num.charAt(i + 2)) {
                max = Math.max(num.charAt(i) - '0', max);
            }
        }
        if(max == -1) return "";
        return String.valueOf(max) + "" + String.valueOf(max) + "" + String.valueOf(max);
    }
}