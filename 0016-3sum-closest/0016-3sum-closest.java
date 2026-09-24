class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int closestSum = nums[0] + nums[1] + nums[2];
        int closestDiff = Math.abs(closestSum - target);

        for(int i=0 ; i<nums.length-2 ; i++){

            int left = i+1 , right = nums.length-1;

            while(left < right){
                int currSum = nums[i] + nums[left] + nums[right];

                if(currSum == target) return currSum;

                else if(currSum < target) left++;

                else right--;

                if(Math.abs(currSum - target) < closestDiff){
                    closestSum = currSum;
                    closestDiff = Math.abs(currSum - target);
                }
            }
        }

        return closestSum;
    }
}