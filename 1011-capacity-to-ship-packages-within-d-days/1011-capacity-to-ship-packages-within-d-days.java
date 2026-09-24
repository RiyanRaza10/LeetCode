class Solution {

    boolean canShip(int[] weights , int days , int maxCap){
        int currDays = 1 , currCap = 0;

        for(int weight : weights){
            if(currCap + weight <= maxCap){
                currCap += weight;
            }

            else{
                currDays++;
                currCap = weight;
            }
        }

        return currDays <= days;
    }

    public int shipWithinDays(int[] weights, int days) {
        int left = -1 , right = 0;

        for(int val : weights){
            left = Math.max(left , val);

            right += val;
        }

        int minCap = 0;

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(canShip(weights , days , mid)){
                minCap = mid;
                right = mid - 1;
            }

            else left = mid + 1;
        }

        return minCap;
    }
}