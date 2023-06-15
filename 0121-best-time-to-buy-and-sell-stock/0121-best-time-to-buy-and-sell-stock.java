class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy= 0;
        int sell = buy+1;
        int max_profit=0;
        
        while(buy<n-1 && sell<n){            
                if(prices[sell]>prices[buy]){
                    int current_profit= prices[sell]-prices[buy];
                    max_profit = Math.max(current_profit, max_profit);
                }
            else {
                buy = sell; // Update the buying index
            }
                
            sell++;
            }
        
        return max_profit;
    }
}