class Solution {
    public long getDescentPeriods(int[] prices) {
        int left = 0 , right = 1;
        long periods = 1;

        while(right < prices.length){

            // If invalid period , eliminate the whole left period
            if(prices[right - 1] != prices[right] + 1){
                left = right;
            }

            periods += right - left + 1;

            right++;
        }

        return periods;
    }
}