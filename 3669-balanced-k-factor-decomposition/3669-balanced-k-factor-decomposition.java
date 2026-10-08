class Solution {
    public int[] minDifference(int n, int k) {
        List<Integer> divisors = new ArrayList<>();

        // Precomputing all divisors of n
        for(int i=n ; i>=1 ; i--){
            if(n % i == 0) divisors.add(i);
        }

        // Answer array 
        int[] ans = new int[k];

        // To keep track of minDiff
        int[] minDiff = new int[]{Integer.MAX_VALUE};

        solve(ans , divisors , new ArrayList<>() , n , k , divisors.size() , minDiff , 1 , 0);

        return ans;

    }

    void solve(int[] ans , List<Integer> divisors , List<Integer> curr , int n , int k , int size , int[] minDiff , int prod , int ind){

        // Invalid combo , go back
        if(curr.size() > k || prod > n) return;

        // Either curr is of size k or reached end of divisors
        // Might find a valid combo
        if(ind == size || curr.size() == k){

            // valid combo
            if(curr.size() == k && prod == n){
                int min = 100000 , max = -1;

                for(int val : curr){
                    min = Math.min(min , val);
                    max = Math.max(max , val);
                }

                // Check if current diff of max and min is less than minDiff
                if(Math.abs(max - min) < minDiff[0]){
                    minDiff[0] = Math.abs(max - min);

                    for(int i=0 ; i<k ; i++){ // Assign
                        ans[i] = curr.get(i);
                    }
                }
            }

            return;
        }

        // Check if this can be a valid divisor
        if(prod * divisors.get(ind) <= n){
            // Pick this divisor
            curr.add(divisors.get(ind));
            prod *= divisors.get(ind);
            
            solve(ans , divisors , curr , n , k , size , minDiff , prod , ind);

            // Not pick this divisor / backtrack
            curr.remove(curr.size()-1);
            prod /= divisors.get(ind);
        }

        // Pick next divisor
        solve(ans , divisors , curr , n , k , size , minDiff , prod , ind+1);
    }
}