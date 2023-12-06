class Solution {
    public int totalMoney(int n) {
        int total = 0;
        int week = 0;
        while(n > 0) {
            int end = 7;
            if( n <= 7) {
                end = n;
            } else {
                end = 7;
            }
            total += getSum(week , week + end);
            n -= 7;
            week++;
        }
        return total;
    }
    public int getSum(int start, int end) {
        int first = start * (start + 1) /2;
        int second = end * (end + 1) /2;
        return second - first;
    }
}


// 4
// week 1 = 1 to 7
//     1 to 

// 1 2 3 4