class Solution {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length+1];
        Arrays.fill(candies, 1);
        
        
        for(int i= 1; i < ratings.length; i++) {
            if(ratings[i] > ratings[i-1]) {
                candies[i] = candies[i-1] + 1;
            }
        }
        
        int[] candies1 = new int[ratings.length+1];
        Arrays.fill(candies1, 1);
        
        for(int i= ratings.length - 2; i >= 0; i--) {
            if(ratings[i] > ratings[i+1]) {
                candies1[i] = candies1[i+1] + 1;
            }
        }
        
        int answer =0;
        for(int i= 0; i < ratings.length; i++) {
            answer += Math.max(candies1[i], candies[i]);
        }
        return answer;
    }
}   