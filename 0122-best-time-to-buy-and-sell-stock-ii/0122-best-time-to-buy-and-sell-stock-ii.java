class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;

        int buy = 100000; // Random

        for(int price : prices){
            
            // Buy at minimum
            if(price <= buy){
                buy = price;
            }

            // If profit can be made , sell
            else if(price > buy){
                profit += (price - buy);
                buy = price;
            }
        }

        return profit;
    }
}