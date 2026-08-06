class Solution {

    void Reverse(int[] nums , int left , int right ){
        while(left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }

    public void rotate(int[] nums, int k) {
        k %= nums.length;

        Reverse(nums , 0 , nums.length-1);

        Reverse(nums , 0 , k-1);

        Reverse(nums , k , nums.length-1);
        
    }
}