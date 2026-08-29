class Solution {

    int factorial(int n){
        int prod = 1;

        while(n > 0){
            prod *= n;
            n--;
        }

        return prod;
    }

    public List<List<Integer>> permute(int[] nums) {

        int totalPermutations = factorial(nums.length);

        List<List<Integer>> permutations = new ArrayList<>();

        while( totalPermutations-- > 0){
            List<Integer> currPermutation = new ArrayList<>();

            for(int val : nums) currPermutation.add(val);

            permutations.add(currPermutation);

            nextPermutation(nums);
        }

        return permutations;
    }

    void nextPermutation(int[] nums){
        int ind = -1 , n = nums.length;

        for(int i=n-2 ; i>=0 ; i--){
            if(nums[i] < nums[i+1]){
                ind = i;
                break;
            }
        }

        if(ind == -1){
            reverse(nums , 0 , n-1);

            return;
        }

        for(int i=n-1 ; i>ind ; i--){
            if(nums[i] > nums[ind]){
                int temp = nums[i];
                nums[i] = nums[ind];
                nums[ind] = temp;

                break;
            }
        }

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