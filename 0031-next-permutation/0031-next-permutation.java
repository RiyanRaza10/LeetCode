class Solution {

    void reverse(int[] nums , int start , int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }

    public void nextPermutation(int[] nums) {
        int ind = -1 , n = nums.length;

        for(int i=n-2 ; i>=0 ; i--){
            if(nums[i] < nums[i+1]){
                ind = i;
                break;
            }
        }

        // Last Permutation found , reverse the whole array to find the smallest permutation (i.e. first)
        if(ind == -1){
            reverse(nums , 0 , n-1);

            return;
        }

        // Find a just greater number than nums[ind] and then swap it with nums[ind] , 
        for(int i=n-1 ; i>ind ; i--){
            if(nums[i] > nums[ind]){
                int temp = nums[i];
                nums[i] = nums[ind];
                nums[ind] = temp;

                break;
            }
        }

        // Reverse array from ind+1 to end to obtain smallest permutation after ind
        reverse(nums , ind+1 , n-1);    
        
    }
}