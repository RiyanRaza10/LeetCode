class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> allCombinations = new ArrayList<>();

        // Digit to Character mappings
        String[] map = new String[]{"" , "" , "abc" , "def" , "ghi" , "jkl" , "mno" , "pqrs" , "tuv" , "wxyz"};

        backtrack(allCombinations , new StringBuilder() , map , digits , 0);

        return allCombinations;

    }

    void backtrack(List<String> allCombinations , StringBuilder currCombination , String[] map , String digits , int ind){

        // Found a valid Combination
        if(currCombination.length() == digits.length()){
            allCombinations.add(currCombination.toString());

            return;
        }

        for(int i=0 ; i<map[digits.charAt(ind) - '0'].length() ; i++){

            currCombination.append(map[digits.charAt(ind) - '0'].charAt(i));

            // Pick
            backtrack(allCombinations , currCombination , map , digits , ind+1);

            // Backtrack
            currCombination.deleteCharAt(currCombination.length()-1);
        }
    }
}