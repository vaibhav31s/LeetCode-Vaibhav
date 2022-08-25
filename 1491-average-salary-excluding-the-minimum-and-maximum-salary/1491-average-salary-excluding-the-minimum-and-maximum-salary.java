class Solution {
    public double average(int[] salary) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        double sum = 0;
        for(int x : salary){
            min = Math.min(min, x);
            max = Math.max(max, x);
            sum += x;
        }
        sum-= min;
        sum -= max;
        return sum / (salary.length - 2);
    }
}