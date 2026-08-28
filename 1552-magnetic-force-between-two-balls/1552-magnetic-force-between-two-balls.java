class Solution {

    boolean canPlaceBalls(int[] position , int balls , int minGap){
        // One ball is always placed at zero
        balls--;

        // We will place balls only if the gap between two balls is atleast "minGap"
        int prevPosition = position[0];

        for(int i=1 ; i<position.length ; i++){

            // We will place balls only if the gap in position of two balls is atleast "minGap"
            if(position[i] - prevPosition >= minGap){
                prevPosition = position[i];
                
                balls--;
            }

            // All balls placed , no need to further check
            if(balls == 0) break;
        }

        // Check if all balls are placed
        return balls == 0;
    
    }

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);

        int n = position.length;

        int left = 1 , right = position[n-1] - position[0];

        int maxForce = -1;

        while(left <= right){
            int mid = left + (right - left) / 2;

            // m balls can be placed with each ball having a minimum gap of mid
            // So increase gap to get maximum result
            if(canPlaceBalls(position , m , mid)){
                maxForce = mid;

                left = mid + 1;
            }

            else right = mid - 1;

        }

        return maxForce;
        
    }
}