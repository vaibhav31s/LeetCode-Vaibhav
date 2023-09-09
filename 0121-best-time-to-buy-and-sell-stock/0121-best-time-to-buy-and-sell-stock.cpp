class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int max1 = 0 , min = prices[0];
        
        for(int i = 0; i <prices.size() ; i++){
            if(min > prices[i]) min = prices[i];
            
            max1 = max(prices[i] - min , max1);
        }
        
        return max1;
    }
};