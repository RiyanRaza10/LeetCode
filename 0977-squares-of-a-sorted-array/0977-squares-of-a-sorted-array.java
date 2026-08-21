class Solution {
    public int[] sortedSquares(int[] nums) {
        
        int i = 0 , j = nums.length-1 , ind = nums.length-1;

        int[] arr = new int[nums.length];
        
        while(ind >= 0){
            int leftSq = nums[i] * nums[i] , rightSq = nums[j] * nums[j];

            if(leftSq >= rightSq){
                arr[ind] = leftSq;
                i++;
            }
            else{
                arr[ind] = rightSq;
                j--;
            }

            ind--;

        }

        return arr;
    }
}