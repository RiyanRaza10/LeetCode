class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<>();

        int[] nums = new int[n];

        for(int i=1 ; i<=n ; i++){
            nums[i-1] = i;
        }

        backtrack(combinations , new ArrayList<>() , nums , k , 0);

        return new ArrayList<>(combinations);
    }

    void backtrack(List<List<Integer>> combinations , List<Integer> currCombination , int[] nums , int k , int ind){

        // Base Case
        if(ind == nums.length){
            if(currCombination.size() == k){
                combinations.add(new ArrayList<>(currCombination));
            }

            return;
        }

        currCombination.add(nums[ind]);

        // Pick 
        backtrack(combinations , currCombination , nums , k , ind+1);

        // Remove used element
        currCombination.remove(currCombination.size()-1);

        // Not pick
        backtrack(combinations , currCombination , nums , k , ind+1);
       
    }
}