class Solution {

    boolean isPossible(int[] houses , int[] heaters , int maxRadius){
        int heaterIndex = 0 , houseIndex = 0;

        while(houseIndex < houses.length){
            if(Math.abs(houses[houseIndex] - heaters[heaterIndex]) <= maxRadius){
                houseIndex++;
            }

            else if(Math.abs(houses[houseIndex] - heaters[heaterIndex]) > maxRadius){
                heaterIndex++;
            }

            if(heaterIndex == heaters.length) break;

        }

        // Check if all houses are covered
        return houseIndex == houses.length;
        
    }

    public int findRadius(int[] houses, int[] heaters) {
        // Minimum radius would be 0
        // Maximum radius would be the farthest position of any house or any heater

        Arrays.sort(houses);
        Arrays.sort(heaters);

        int left = 0 , right = -1 , minRadius = 0;

        for(int houseNumber : houses) right = Math.max(right , houseNumber);

        for(int heaterNumber : heaters) right = Math.max(heaterNumber , right);

        while(left <= right){
            int mid = left + (right - left) / 2;

            // Check if we can place heaters with atmost "mid" radius
            // If we can , reduce the radius(mid)
            if(isPossible(houses , heaters , mid)){
                minRadius = mid;

                right = mid - 1;
            }

            else left = mid + 1;
        }

        return minRadius;
    }
}