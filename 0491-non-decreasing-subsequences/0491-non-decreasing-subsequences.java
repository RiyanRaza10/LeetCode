class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {       
        Set<List<Integer>> allCombinations = new HashSet<>();

        backtrack(allCombinations , new ArrayList<>() , nums , 0);

        return new ArrayList<>(allCombinations);
    }

    void backtrack(Set<List<Integer>> allCombinations , List<Integer> currCombination , int[] nums , int ind){

        // Check if subsequence is non-decreasing
        if(currCombination.size() >= 2 && currCombination.get(currCombination.size()-1) < currCombination.get(currCombination.size()-2)) return;

        // Poosible combination
        if(ind == nums.length){
            if(currCombination.size() >= 2) allCombinations.add(new ArrayList<>(currCombination));

            return;
        }

        currCombination.add(nums[ind]);

        // Pick
        backtrack(allCombinations , currCombination , nums , ind+1);

        currCombination.removeLast();

        // Not pick
        backtrack(allCombinations , currCombination , nums , ind+1);
    }
}