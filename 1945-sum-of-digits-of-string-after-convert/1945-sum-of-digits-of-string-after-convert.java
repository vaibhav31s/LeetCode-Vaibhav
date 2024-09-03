class Solution {
    public int getLucky(String s, int k) {
        int sum = sumOfString(s.toCharArray());
        while (k-- > 1 && sum >= 10) {
            sum = getDigitSum(sum);
        }
        return sum;
    }
    
    int sumOfString(char[] arr) {
        int curSum = 0;
        for (char ch : arr) {
            int curVal = (ch - 'a') + 1;
            curSum += getDigitSum(curVal);
        }
        return curSum;
    }
    
    int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            sum += digit;
            num /= 10;
        }
        return sum;
    }
}