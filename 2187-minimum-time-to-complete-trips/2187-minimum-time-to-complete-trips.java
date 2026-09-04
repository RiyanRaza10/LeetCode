class Solution {

    boolean isPossible(int[] time , int reqTrips , long maxTime){
        long currTrips = 0;

        // Check how many trips can each bus complete within maxTime
        // Check if they all can complete at least reqTrips combinedly
        for(int val : time){
            currTrips += (maxTime / val);

            if(currTrips >= reqTrips) return true;
        }

        return false;
    }

    public long minimumTime(int[] time, int totalTrips) {
        long left = 1 , right = 100000000 , minTime = 0;

        for(int val : time) right = Math.min(right , val);

        // Worst case scenario : one bus has to complete all trips
        // Eg : time = [5] , totalTrips = 5
        // then minTime = 25
        right = right * (long)totalTrips;

        while(left <= right){
            long mid = left + (right - left) / 2;

            // Check if all buses can complete totaltrips within "mid" time
            // If they can , reduce the time to get minimum possible result
            if(isPossible(time , totalTrips , mid)){
                minTime = mid;
                right = mid - 1;
            }

            else left = mid + 1;
        }

        return minTime;

    }
}