class Solution {

    long findSpeed(int[]piles , int speed){
        long ans = 0;

        for(int pile : piles){
            ans += (long)Math.ceil((double)(pile) / speed);
        }
        
        return ans;
        
    }

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1 , right = Integer.MIN_VALUE;

        for(int val : piles){
            if(val > right) right = val;
        }

        int minHours = 1;

        while(left <= right){
            int mid = left + (right - left) / 2;

            long currHours = findSpeed(piles , mid);

            // Minimum found
            if(currHours <= (long)h){
                
                minHours = mid;

                right = mid - 1; 
            }

            else left = mid + 1;
        }

        return minHours;
    }
}