class Solution {
    public int minimumBeautifulSubstrings(String s) {
        int[] ans = new int[]{Integer.MAX_VALUE};

        solve(s , new ArrayList<>() , ans , 0);

        return ans[0] == Integer.MAX_VALUE ? -1 : ans[0];
    }

    void solve(String s , List<String> curr , int[] ans , int ind){

        // Partitioned till last
        if(ind == s.length()){
            ans[0] = Math.min(ans[0] , curr.size());

            return;
        }

        for(int i=ind ; i<s.length() ; i++){

            if(isBeautiful(s , ind , i)){
                curr.add(s.substring(ind , i+1));

                // Recursive call
                solve(s , curr , ans , i+1);

                // Backtrack
                curr.remove(curr.size()-1);
            }
        }
    }

    boolean isBeautiful(String s , int start , int end){
        // Cannot start with zero
        if(s.charAt(start) == '0') return false;

        int prod = 1 , num = 0;

        // Convert to integer
        while(end >= start){
            if(s.charAt(end) == '1') num += prod;
            
            prod *= 2;

            end--;
        }

        // Check if it is a power of 5
        while(num % 5 == 0){
            num /= 5;
        }

        return num == 1;
    }

}