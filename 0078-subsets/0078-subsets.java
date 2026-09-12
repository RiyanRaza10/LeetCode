class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> allSubsets = new ArrayList<>();
        
        backtrack(allSubsets , new ArrayList<>() , nums , 0);

        return allSubsets;

    }

    void backtrack(List<List<Integer>> allSubsets , List<Integer> currSubset , int[] nums , int ind){

        // Base Case
        if(ind == nums.length){
            allSubsets.add(new ArrayList<>(currSubset));
            return;
        }

        currSubset.add(nums[ind]);

        // Pick
        backtrack(allSubsets , currSubset , nums , ind+1);

        // Remove used element
        currSubset.remove(currSubset.size()-1);

        // Not pick
        backtrack(allSubsets , currSubset , nums , ind+1);

    }
}