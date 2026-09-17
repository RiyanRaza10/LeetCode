class Solution {
    public List<String> validStrings(int n) {
        List<String> validStrings = new ArrayList<>();

        backtrack(validStrings , new StringBuilder() , n);

        return validStrings;
    }

    void backtrack(List<String> validStrings , StringBuilder curr , int n){
        
        // Length exceed the required length , go back
        if(curr.length() > n) return;

        // Valid String found
        if(curr.length() == n){
            validStrings.add(curr.toString());

            return;
        }

        // Can use '0' , only if curr is empty or last insered character is '1'
        if(curr.length() == 0 || curr.charAt(curr.length()-1) == '1'){
            curr.append("0");

            backtrack(validStrings , curr , n);

            curr.deleteCharAt(curr.length()-1);
        }

        // Can use '1' anytime
        curr.append("1");

        backtrack(validStrings , curr , n);

        // Backtrack
        curr.deleteCharAt(curr.length()-1);

    }
}