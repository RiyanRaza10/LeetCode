class Solution {
    boolean canPlaceAll(int[] position , int balls , int maxDist){
        balls--;

        int prev = position[0];

        for(int i=1 ; i<position.length ; i++){
            if(position[i] - prev >= maxDist){
                balls--;
                prev = position[i];
            }

            if(balls <= 0) break;
        }

        return balls <= 0;
    }
    
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);

        int left = 0 , right = position[position.length-1] , ans = 0;

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(canPlaceAll(position , m , mid)){
                left = mid + 1;
                ans = mid;
            }

            else right = mid - 1;

        }

        return ans;
    }
}