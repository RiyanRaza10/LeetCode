class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        Set<List<Integer>> uniqueSubsets = new HashSet<>();

        backtrack(uniqueSubsets , new ArrayList<>() , nums , 0);

        return new ArrayList<>(uniqueSubsets);
    }

    void backtrack(Set<List<Integer>> uniqueSubsets , List<Integer> currSubset , int[] nums , int ind){

        // Base Case
        if(ind == nums.length){
            uniqueSubsets.add(new ArrayList<>(currSubset));    
            return;
        }

        currSubset.add(nums[ind]);

        // Pick
        backtrack(uniqueSubsets , currSubset , nums , ind+1);

        // Remove used element
        currSubset.remove(currSubset.size()-1);

        // Not pick
        backtrack(uniqueSubsets , currSubset , nums , ind+1);
    }
}