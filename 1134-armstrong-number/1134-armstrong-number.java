class Solution {
    public boolean isArmstrong(int n) {
        int start = n;
        int sum = 0;
        int digit =(int)(Math.log(n) / Math.log(10)) +1;
        while(n > 0){
            int last = n % 10;
            
            sum += Math.pow(last,digit );
            n/=10;
        }
        return sum == start;
    }
}