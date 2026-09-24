class Solution {

    boolean canMakeAll(int[] bloomDay , int m , int k , int maxdays){
        long currBouquet = 0;
        int currGroupSize = 0;

        for(int i=0 ; i<bloomDay.length ; i++){
            if(bloomDay[i] <= maxdays){
                currGroupSize++;
            }

            else{
                currGroupSize = 0;
            }

            if(currGroupSize == k){
                currBouquet++;
                currGroupSize = 0;
            }
        }

        return currBouquet >= m;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        if((long)m * k > bloomDay.length) return -1;

        int left = 1 , right = -1 , minDays = -1;

        for(int val : bloomDay) right = Math.max(right , val);

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(canMakeAll(bloomDay , m , k , mid)){
                minDays = mid;
                right = mid - 1;
            }

            else left = mid + 1;
        }

        return minDays;
    }
}