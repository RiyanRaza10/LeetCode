class Solution {

    boolean isPossible(int[] dist , double maxTime , int currSpeed){
        double currTime = 0;

        for(int i=0 ; i<dist.length ; i++){

            if(i != dist.length-1){
                currTime += Math.ceil((double)dist[i] / currSpeed);
            }

            // No need to round off time on the last train
            else currTime += (double)(dist[i]) / currSpeed;
        }

        return currTime <= maxTime;
    }

    public int minSpeedOnTime(int[] dist, double hour) {
        
        // Impossible to board all trains
        if(dist.length > Math.ceil(hour)) return -1;

        // Answer will lie between 1 and 1e7 {Given in question}
        int left = 1 , right = 10000000 , minSpeed = -1;

        while(left <= right){
            int mid = left + (right - left) / 2;

            // Check if we can board all trains with speed "mid" within maxTime(hour)
            // If possible , reduce the speed
            if(isPossible(dist , hour , mid)){
                minSpeed = mid;

                right = mid - 1;
            }

            else left = mid + 1;
        }

        return minSpeed;
    }
}