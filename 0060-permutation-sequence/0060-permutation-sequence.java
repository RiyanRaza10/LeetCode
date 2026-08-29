class Solution {
    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        nums[0] = 1;

        // Build array
        for(int i=1 ; i<n ; i++){
            nums[i] = nums[i-1] + 1;
        }

        // Permute array k times
        for(int i=1 ; i<k ; i++){
            nextPermutation(nums , n);
        }

        // Return array as a string
        StringBuilder desiredPermutation = new StringBuilder();

        for(int val : nums) {
            desiredPermutation.append(val);
        }

        return desiredPermutation.toString();

    }

    void nextPermutation(int[] nums , int n){
        int ind = -1;

        // Find the first index which has smaller element than its next 
        for(int i=n-2 ; i>=0 ; i--){
            if(nums[i] < nums[i+1]){
                ind = i;
                break;
            }
        }

        // Greatest permutation found , return smallest
        if(ind == -1){
            reverse(nums , 0 , n-1);

            return;
        }

        // Find just greater element than nums[ind] from last
        // Then swap it with nums[ind]
        for(int i=n-1 ; i>=0 ; i--){

            if(nums[i] > nums[ind]){
                int temp = nums[i];
                nums[i] = nums[ind];
                nums[ind] = temp;

                break;
            }
        }

        // Reverse nums after ind to get smallest permutation after ind
        reverse(nums , ind+1 , n-1); 
    }

    void reverse(int[] nums , int start , int end){

        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
        
    }
}