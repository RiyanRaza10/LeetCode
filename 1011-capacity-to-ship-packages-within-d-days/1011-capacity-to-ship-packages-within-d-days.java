class Solution {

    int calculateDays(int[] weights , int capacity){
        int ans = 1 , currCap = 0;

        for(int weight : weights){
            if(currCap + weight <= capacity){
                currCap += weight;
            }
            else{
                ans++;
                currCap = weight;
            }
        }

        return ans;
    }

    public int shipWithinDays(int[] weights, int days) {
        int left = -1 , right = 0;

        for(int weight : weights){
            if(weight > left) left = weight;

            right += weight;
        }

        int minCapacity = right;

        while(left <= right){
            int mid = left + (right - left) / 2;

            int currDays = calculateDays(weights , mid);

            // Valid Day found
            if(currDays <= days){
                minCapacity = mid;
                right = mid - 1;
            }

            else left = mid + 1;
        }

        return minCapacity;
    }
}