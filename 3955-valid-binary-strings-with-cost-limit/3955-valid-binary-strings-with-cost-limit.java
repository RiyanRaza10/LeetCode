// This question is a follow up for : 3211. Generate Binary Strings Without Adjacent Zeros
class Solution {
    public List<String> generateValidStrings(int n, int k) {
        List<String> validStrings = new ArrayList<>();

        solve(validStrings , new StringBuilder() , 0 , n , k);

        return validStrings;
    }

    void solve(List<String> validStrings , StringBuilder curr , int cost , int n , int k){
        // Invalid
        if(cost > k) return;
        
        // Could be a valid string
        if(curr.length() == n){
            if(cost <= k) validStrings.add(curr.toString());

            return;
        }

        // Can use '1' only if it is first character OR last inserted is not '1'
        if(curr.length() == 0 || curr.charAt(curr.length()-1) != '1'){
            cost += curr.length();
            curr.append("1");

            // Recursive call
            solve(validStrings , curr , cost , n , k);

            // Backtrack
            cost -= curr.length() - 1;
            curr.deleteCharAt(curr.length()-1);
        }

        curr.append("0");

        // Recursive call
        solve(validStrings , curr , cost , n , k);

        // Backtrack
        curr.deleteCharAt(curr.length()-1);
    }
}