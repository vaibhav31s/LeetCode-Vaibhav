class Solution {
    public String largestGoodInteger(String num) {
        char max = '-';
        int win = 3;
        for(int i = 0; i <= num.length() - 3; i++) {
            if(num.charAt(i) == num.charAt(i + 1) && num.charAt(i + 1) == num.charAt(i + 2)) {
                if(max < num.charAt(i)){
                    max = num.charAt(i);
                }
            }
        }
        if(max == '-') return "";
        return new String(new char[] {max, max, max});
    }
}