class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> validCombinations = new ArrayList<>();

        int[] nums = new int[]{1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9};

        backtrack(validCombinations , new ArrayList<>() , nums , k , n , 0 , 0);

        return validCombinations;

    }

    void backtrack(List<List<Integer>> validCombinations , List<Integer> currCombination , int[] nums , int k , int target , int currSum , int ind){

        // Cannot pick further , go back
        if(currSum > target) return;

        // Found a combination
        if(currSum == target){
            if(currCombination.size() == k){
                validCombinations.add(new ArrayList<>(currCombination));
            }

            return;
        }
        
        for(int i=ind ; i<nums.length ; i++){

            currSum += nums[i];
            currCombination.add(nums[i]);

            // Pick
            backtrack(validCombinations , currCombination , nums , k , target , currSum , i+1);

            // Remove used element
            currSum -= currCombination.getLast();
            currCombination.removeLast();

        }
    }
}