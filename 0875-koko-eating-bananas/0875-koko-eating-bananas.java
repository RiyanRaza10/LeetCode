class Solution {

    boolean canEatAll(int[] piles , long speed , int hours){
        long currHours = 0;

        for(int pile : piles){
            currHours += (long)Math.ceil((double)(pile) / speed);
        }
        
        return currHours <= hours;
    }

    public int minEatingSpeed(int[] piles, int h) {
        long left = 1 , right = -1;

        for(int val : piles) right = Math.max(right , val);

        long ans = 1;

        while(left <= right){
            long mid = left + (right - left) / 2;

            if(canEatAll(piles , mid , h)){
                ans = mid;
                right = mid - 1;
            }

            else left = mid + 1;
        }

        return (int)ans;
    }
}