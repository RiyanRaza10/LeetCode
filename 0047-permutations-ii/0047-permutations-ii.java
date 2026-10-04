class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;

        List<List<Integer>> uniquePermutations = new ArrayList<>();
        boolean[] used = new boolean[n];

        generate(uniquePermutations , new ArrayList<>() , used , nums , n);

        return uniquePermutations;
    }

    void generate(List<List<Integer>> uniquePermutations , List<Integer> currPermutation , boolean[] used , int[] nums , int n){

        // A Permutation formed
        if(currPermutation.size() == n){
            uniquePermutations.add(new ArrayList<>(currPermutation));

            return;
        }

        for(int i=0 ; i<n ; i++){

            if(!used[i]){
                
                // Skip duplicates
                // Will not generate when previous number(if duplicate) is not used
                if(i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;

                // Pick
                used[i] = true;
                currPermutation.add(nums[i]);

                // Recursive call 
                generate(uniquePermutations , currPermutation , used , nums , n);

                // Backtrack
                used[i] = false;
                currPermutation.remove(currPermutation.size()-1);

            }
        }
    }
}