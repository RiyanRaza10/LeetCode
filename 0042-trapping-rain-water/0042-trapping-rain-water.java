class Solution {
    public int trap(int[] height) {
        int left = 0 , right = height.length-1 , water = 0 , leftMax = 0 , rightMax = 0;

        while(left <= right){
            if(height[left] < height[right]){
                leftMax = Math.max(leftMax , height[left]);

                water += leftMax - height[left];
                left++;
            }

            else{
                rightMax = Math.max(height[right] , rightMax);

                water += rightMax - height[right];

                right--;
            }
        }

        return water;
    }
}