class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        solve(res, new ArrayList<>(), candidates, target , 0);

        return res;
    }

    void solve(List<List<Integer>> res, List<Integer> curr, int[] nums, int target, int ind) {
        
        if(0 == target){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i=ind ; i<nums.length ; i++){
            if(target - nums[i] >= 0){
                curr.add(nums[i]);
                solve(res , curr , nums , target-nums[i] , i);
                curr.remove(curr.size()-1);
            }
        }
        
    }
}