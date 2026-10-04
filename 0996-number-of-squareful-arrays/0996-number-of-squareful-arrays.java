class Solution {
    public int numSquarefulPerms(int[] nums) {
        // Array is sorted to keep track of duplicates
        Arrays.sort(nums);
        
        int[] ans = new int[1];

        int n = nums.length;

        List<List<Integer>> validPermutations = new ArrayList<>();
        boolean[] used = new boolean[n];

        solve(nums , validPermutations , new ArrayList<>() , used , ans , n , 0);

        return ans[0];
    }

    void solve(int[] nums , List<List<Integer>> validPermutations , List<Integer> curr , boolean[] used , int[] ans , int n , int ind){
        
        // A Valid Permutation formed
        if(curr.size() == n){
            ans[0]++;
            validPermutations.add(new ArrayList<>(curr));

            return;
        }

        for(int i=0 ; i<n ; i++){
            
            if(!used[i]){

                // Skip generating duplicate permutations
                // If 2 numbers are same , it will not generate when previous number is not used
                if(i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;
                
                // Check if adjacent are not squares , no need to take this element
                // (not generate this permutation)
                if(curr.size() > 0){
                    long num = (long)curr.get(curr.size()-1) + nums[i];
                    long sqrt = (long)Math.sqrt(num);
                    long sq = (long)sqrt * sqrt;

                    if(sq != num) continue;
                }

                // Pick 
                used[i] = true;
                curr.add(nums[i]);

                // Recursive call
                solve(nums , validPermutations , curr , used , ans , n , i+1);

                // Backtrack
                used[i] = false;
                curr.remove(curr.size()-1);
            }
        }
    }
}