class Solution {
    public List<String> validStrings(int n) {
        List<String> validCombinations = new ArrayList<>();

        backtrack(validCombinations , new StringBuilder() , n);

        return validCombinations;
    }

    void backtrack(List<String> validCombinations , StringBuilder curr , int n){
        
        // Oversized string , go back
        if(curr.length() > n) return;

        // Valid Combination found
        if(curr.length() == n){
            validCombinations.add(curr.toString());

            return;
        }

        // Initial combination , can use both '0' and '1'
        if(curr.length() == 0){
            curr.append("0");

            backtrack(validCombinations , curr , n);

            curr.deleteCharAt(curr.length()-1);
        }

        // Check if last used char is not '0'
        if(curr.length() > 0 && curr.charAt(curr.length()-1) == '1'){
            curr.append("0");

            backtrack(validCombinations , curr , n);

            curr.deleteCharAt(curr.length()-1);
        }

        // Append '1'
        curr.append("1");

        backtrack(validCombinations , curr , n);

        // Backtrack
        curr.deleteCharAt(curr.length()-1);
        
    }
}