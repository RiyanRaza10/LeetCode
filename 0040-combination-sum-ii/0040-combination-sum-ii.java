class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // To be able to eliminate duplicates
        Arrays.sort(candidates);
        
        List<List<Integer>> uniqueCombinations = new ArrayList<>();

        backtrack(uniqueCombinations , new ArrayList<>() , candidates , target , 0 , 0);

        return uniqueCombinations;

    }

    void backtrack(List<List<Integer>> uniqueCombinations , List<Integer> currCombination , int[] candidates , int target , int currSum , int ind){

        // Cannot pick further , go back
        if(currSum > target) return;

        // Found a combination
        if(currSum == target){
            uniqueCombinations.add(new ArrayList<>(currCombination));

            return;
        }

        for(int i=ind ; i<candidates.length ; i++){

            // Skip using current number again
            if(i > ind && candidates[i] == candidates[i-1]) continue;

            // Pick
            currSum += candidates[i];
            currCombination.add(candidates[i]);

            backtrack(uniqueCombinations , currCombination , candidates , target , currSum , i+1);

            // Remove used element
            currSum -= currCombination.get(currCombination.size()-1);
            currCombination.remove(currCombination.size()-1);

        }
    }
}