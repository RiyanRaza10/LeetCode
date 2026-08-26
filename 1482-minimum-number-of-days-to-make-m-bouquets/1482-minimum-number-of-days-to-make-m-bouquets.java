class Solution {

    long calculateTotalBouquets(int[] bloomDay , int k , int maxDay){
        int cnt = 0;
        long totalBouquets = 0;

        for(int val : bloomDay){
            if(val <= maxDay){
                cnt++;
            }

            else{
                totalBouquets += (cnt / k);
                cnt = 0;
            }
        }

        totalBouquets += (cnt / k);

        return totalBouquets;

    }

    public int minDays(int[] bloomDay, int m, int k) {
        
        // Flowers kam pad gye
        if((long)m * k > bloomDay.length) return -1;

        int left = Integer.MAX_VALUE , right = -1;

        for(int val : bloomDay){
            if(val < left) left = val;
            if(val > right ) right = val;
        }

        int minDays = right;

        while(left <= right){
            int mid = left + (right - left) / 2;

            long currBouquetsFormed = calculateTotalBouquets(bloomDay , k , mid);

            // Valid number of bouquet formed
            if(currBouquetsFormed >= (long)m){
                minDays = mid;
                right = mid -1;
            }

            else left = mid + 1;

        }

        return minDays;
    
    }
}