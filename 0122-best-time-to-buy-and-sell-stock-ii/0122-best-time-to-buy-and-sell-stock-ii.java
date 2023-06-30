class Solution {
    public int maxProfit(int[] prices) {
        int i = 0;
        int buy = 0;
        int sell = 0;
        int profit = 0;
        int n = prices.length-1;
        
        while(i<n){
            while(i<n && prices[i+1]<=prices[i])i++;
            buy= prices[i];

            while(i<n && prices[i+1]>prices[i])i++;
            sell=prices[i];
            
            profit+=sell-buy;
        }
        return profit;
    }
}