class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> allPermutations = new ArrayList<>();

        // To keep track of used element
        boolean[] used = new boolean[nums.length];

        backtrack(allPermutations , new ArrayList<>() , used , nums);

        return allPermutations;
    }

    void backtrack(List<List<Integer>> allPermutations , List<Integer> currPermutation , boolean[] used , int[] nums){

        // Base case : when we have used n number of elements 
        if(currPermutation.size() == nums.length){
            allPermutations.add(new ArrayList<>(currPermutation));

            return;
        }

        for(int i=0 ; i<nums.length ; i++){
            
            // Use current number , if not used
            if(!used[i]){
                
                // Mark as used
                used[i] = true;
                currPermutation.add(nums[i]);

                // Pick
                backtrack(allPermutations , currPermutation , used , nums);

                // Unmark and remove used element
                used[i] = false;
                currPermutation.removeLast();
            }
        }
    }
}