class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> allCombinations = new ArrayList<>();

        generate(allCombinations , new StringBuilder() , n , 0 , 0);

        return allCombinations;
    }

    void generate(List<String> allCombinations , StringBuilder res , int n , int open , int close){

        // Invalid Combination
        if(open > n || close > n || close > open) return;

        // Valid Combination Found
        if(open == n && close == n){
            allCombinations.add(res.toString());

            return;
        }
        
        // Pick "("
        generate(allCombinations , res.append("(") , n , open+1 , close);

        // Backtrack
        res.deleteCharAt(res.length()-1);

        // Pick ")"
        generate(allCombinations , res.append(")") , n , open , close+1);

        // Backtrack
        res.deleteCharAt(res.length()-1);
        
    }
}