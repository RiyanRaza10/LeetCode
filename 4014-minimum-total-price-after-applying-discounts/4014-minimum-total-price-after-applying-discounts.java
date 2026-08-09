class Solution {
    public double minPrice(int[] prices, int[] discounts) {
        Arrays.sort(prices);
        Arrays.sort(discounts);

        double totalPrice = 0;

        int j = discounts.length-1;

        for(int i = prices.length-1 ; i >= 0 ; i--){
            
            if(j >= 0) totalPrice += (double)prices[i] * (100 - discounts[j]) / 100.0;
            else totalPrice += prices[i];

            j--;

        }

        return totalPrice;
    }
}