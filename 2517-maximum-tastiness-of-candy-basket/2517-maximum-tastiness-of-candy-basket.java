class Solution {

    boolean isPossible(int[] price , int k , int minDiff){
        // Difference in price of two candies should be at least minDiff
        int prevElem = price[0] , choosenCandies = 1;

        for(int i=1 ; i<price.length ; i++){
            if(price[i] - prevElem >= minDiff){
                choosenCandies++;

                prevElem = price[i];
            }
        }

        // Check if we can buy at least k candies
        return choosenCandies >= k;
    }

    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);

        int left = 0 , right = price[price.length-1] - price[0] , ans = 0;

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(isPossible(price , k , mid)){
                ans = mid;
                left = mid + 1;
            }

            else right = mid -1;
        }

        return ans;
    }
}