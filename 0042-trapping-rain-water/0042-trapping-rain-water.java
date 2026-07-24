class Solution {
    public int trap(int[] height) {
        
        int water = 0 , left = 0 , right = height.length-1 , leftMax = 0 , rightMax = 0;

        while(left < right){
            
            // Work on left side
            if(height[left] < height[right]){
                leftMax = height[left] > leftMax ? height[left] : leftMax;
                water += ( leftMax - height[left] );
                left++;
            }

            // Work on right side
            else{
                rightMax = height[right] > rightMax ? height[right] : rightMax;
                water += (rightMax - height[right]);
                right--;
            }
        }

        return water;
    }
}