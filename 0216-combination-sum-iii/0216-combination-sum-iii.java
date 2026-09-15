class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> validCombinations = new ArrayList<>();

        backtrack(validCombinations , new ArrayList<>() , k , n , 0 , 1);

        return validCombinations;

    }

    void backtrack(List<List<Integer>> validCombinations , List<Integer> currCombination , int k , int target , int currSum , int start){

        // Cannot make further combinations , invalid condition reached
        if(currCombination.size() > k || currSum > target) return;

        // Possible valid combination found
        if(currSum == target){
            if(currCombination.size() == k){
                validCombinations.add(new ArrayList<>(currCombination));
            }

            return;
        } 

        // Can pick only from start to 9
        for(int i=start ; i<=9 ; i++){

            currSum += i;
            currCombination.add(i);

            // Pick next
            backtrack(validCombinations , currCombination , k , target , currSum , i+1);

            // Remove used element
            currSum -= i;
            currCombination.removeLast();

        }
    }
}