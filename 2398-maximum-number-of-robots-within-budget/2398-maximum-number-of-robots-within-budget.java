class Solution {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int n = chargeTimes.length;
        int left = 0 , right = n , maxRobots = 0;

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(canBuy(chargeTimes , runningCosts , budget , mid)){
                left = mid+1;
                maxRobots = mid;
            }

            else right = mid-1;
        }

        return maxRobots;
    }

    boolean canBuy(int[] chargeTimes , int[] runningCosts , long budget , int k){
        long runCost = 0;

        Deque<Integer> dq = new ArrayDeque<>();

        // Find maximum chargeTime in every window of size k
        for(int i=0 ; i<chargeTimes.length ; i++){
            runCost += runningCosts[i];
            if(i >= k) runCost -= runningCosts[i-k];

            while(!dq.isEmpty() && dq.peekFirst() <= i-k) dq.pollFirst();

            while(!dq.isEmpty() && chargeTimes[dq.peekLast()] < chargeTimes[i]) dq.pollLast();

            dq.offerLast(i);

            // Check if valid window exists
            if(i >= k-1 && (long)(chargeTimes[dq.peekFirst()]) + (long)k * (long)runCost <= budget) return true;
        }

        return false;
    }
}