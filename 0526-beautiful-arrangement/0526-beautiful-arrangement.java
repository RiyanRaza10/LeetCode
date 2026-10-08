class Solution {
    public int countArrangement(int n) {
        int[] nums = new int[n];
        int[] ans = new int[1];

        boolean[] used = new boolean[n];

        for(int i=0 ; i<n ; i++) nums[i] = i+1;

        solve(new ArrayList<>() , nums , used , ans , n);

        return ans[0];
    }

    void solve(List<Integer> curr , int[] nums , boolean[] used , int[] ans , int n){
        
        // A valid Permutation formed
        if(curr.size() == n){
            ans[0]++;

            return;
        }

        for(int i=0 ; i<n ; i++){

            if(!used[i]){
                
                int ind = curr.size()+1;

                if(nums[i] % ind == 0 || ind % nums[i] == 0){
                    
                    // Pick
                    used[i] = true;
                    curr.add(nums[i]);

                    // Recursive call
                    solve(curr , nums , used , ans , n);

                    // Not pick
                    used[i] = false;
                    curr.remove(curr.size()-1);
                }
            }
        }
    }
}