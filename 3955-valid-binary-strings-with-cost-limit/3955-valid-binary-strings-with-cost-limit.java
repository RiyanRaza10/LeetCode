class Solution {
    public List<String> generateValidStrings(int n, int k) {
        List<String> validStrings = new ArrayList<>();

        solve(validStrings , new StringBuilder() , n , k);

        return validStrings;
    }

    void solve(List<String> validStrings , StringBuilder curr , int n , int k){
        
        if(curr.length() == n){
            int cost = 0;

            // Calculate cost
            for(int i=0 ; i<n ; i++){
                if(curr.charAt(i) == '1') cost += i;
            }

            if(cost <= k) validStrings.add(curr.toString());

            return;
        }

        // Can use '1' only if it is first character OR last inserted is not '1'
        if(curr.length() == 0 || curr.charAt(curr.length()-1) != '1'){
            curr.append("1");

            // Recursive call
            solve(validStrings , curr , n , k);

            // Backtrack
            curr.deleteCharAt(curr.length()-1);
        }

        curr.append("0");

        // Recursive call
        solve(validStrings , curr , n , k);

        // Backtrack
        curr.deleteCharAt(curr.length()-1);
    }
}