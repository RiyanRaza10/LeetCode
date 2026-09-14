class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> uniqueCombinations = new ArrayList<>();

        backtrack(uniqueCombinations , new ArrayList<>() , candidates , target , 0 , 0);

        return uniqueCombinations;

    }

    void backtrack(List<List<Integer>> uniqueCombinations , List<Integer> currCombination , int[] candidates , int target , int currSum , int ind){

        // Cannot pick aage ke element further
        if(currSum > target) return;

        // Found a valid combination
        if(currSum == target){
            uniqueCombinations.add(new ArrayList<>(currCombination));

            return;
        }

        for(int i=ind ; i<candidates.length ; i++){

            currSum += candidates[i];
            currCombination.add(candidates[i]);

            // Pick current element again
            backtrack(uniqueCombinations , currCombination , candidates , target , currSum , i);

            // Remove used element , cannot pick this element further
            currSum -= currCombination.get(currCombination.size()-1);
            currCombination.remove(currCombination.size()-1);
            
        }
    }
}