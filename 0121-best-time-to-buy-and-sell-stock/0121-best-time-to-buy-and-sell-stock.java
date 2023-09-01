class Solution {
    public int maxProfit(int[] prices) {
        int answer = 0;
        
        int min = prices[0];
        for (int x : prices) {
            min = Math.min(x, min);
            answer = Math.max(answer, x - min);
        }
        
        return answer;
    }
}