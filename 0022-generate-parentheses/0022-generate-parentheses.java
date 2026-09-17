class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> allCombinations = new ArrayList<>();

        backtrack(allCombinations , new StringBuilder() , n , 0 , 0);

        return allCombinations;

    }

    void backtrack(List<String> allCombinations , StringBuilder curr , int n , int open , int closed){

        // Invalid parentheses , go back
        if(open > n || closed > n || closed > open) return;

        // Valid combination
        if(curr.length() == 2*n){
            allCombinations.add(curr.toString());

            return;
        }

        // Append open paren
        if(open < n){
            curr.append("(");

            backtrack(allCombinations , curr , n , open+1 , closed);

            curr.deleteCharAt(curr.length()-1);
        }

        // Append closed paren
        if(closed < n){
            curr.append(")");

            backtrack(allCombinations , curr , n , open , closed+1);

            curr.deleteCharAt(curr.length()-1);
        }


    }
}