class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> validCombinations = new ArrayList<>();

        backtrack(validCombinations , new ArrayList<>() , candidates , target , 0 , 0);

        return validCombinations;
    }

    void backtrack(List<List<Integer>> validCombinations , List<Integer> currCombination , int[] candidates , int target , int currSum , int ind){
        
        // Invalid combination , go back
        if(currSum > target) return;
        
        // Base case
        if(ind == candidates.length){
            if(currSum == target){
                validCombinations.add(new ArrayList<>(currCombination));
            }

            return;
        }

        currSum += candidates[ind];
        currCombination.add(candidates[ind]);

        // Pick current element again
        backtrack(validCombinations , currCombination , candidates , target , currSum , ind);

        currSum -= currCombination.get(currCombination.size()-1);
        currCombination.remove(currCombination.size()-1);

        // Not pick current element again
        backtrack(validCombinations , currCombination , candidates , target , currSum , ind+1);
 
    }
}