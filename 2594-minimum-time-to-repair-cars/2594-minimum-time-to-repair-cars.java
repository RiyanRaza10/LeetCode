class Solution {

    boolean canRepairAll(int[] ranks , int totalCars , long maxTime){
        // Key Idea : Check how many cars can each mechanic repair in "maxTime" minutes
        long carsRepaired = 0;

        for(int i=0 ; i<ranks.length ; i++){

            // Since , from ques
            // ranks[i] * (cars * cars) <= maxTime
            int carsRepairedByCurrMechanic = (int)Math.sqrt(maxTime / ranks[i]);

            carsRepaired += carsRepairedByCurrMechanic;
            
        }
        
        // Check if all of them combined , can repair all the cars
        return carsRepaired >= totalCars;

    }


    public long repairCars(int[] ranks, int cars) {
        long left = 1 , right = 101 , minTime = 1;

        for(int rank : ranks) right = Math.min(right , rank);

        // Worst case : one mechanic has to repair all cars
        minTime = right * ((long)cars * cars);

        // Max search space
        right = minTime;

        while(left <= right){
            long mid = left + (right - left) / 2;

            // Check how many cars can each mechanic repair in "mid" minutes
            // If they can repair at least "cars" no. of cars , reduce the time to get minimum time
            if(canRepairAll(ranks , cars , mid)){
                minTime = mid;

                right = mid - 1;
            }

            else left = mid + 1;
        }

        return minTime;
    }
}