class Solution {
    public int countMaxOrSubsets(int[] nums) {
        HashMap<Integer , Integer> map = new HashMap<>();
        solve(nums , map , new ArrayList<>() , 0);

        int maxOr = nums[0];
        for(int key : map.keySet()){
            if(map.get(key) > map.get(maxOr)) maxOr = key;
        }

        return map.get(maxOr);
    }

    void solve(int[] nums , HashMap<Integer , Integer> map , List<Integer> curr , int ind){

        if(ind == nums.length){
            
            if(curr.size() > 0){
                int or = curr.get(0);
                for(int v : curr) or |= v;

                map.put(or , map.getOrDefault(or , 0) + 1);
            }

            return;
        }

        curr.add(nums[ind]);
        solve(nums , map , curr , ind+1);
        curr.remove(curr.size()-1);

        solve(nums , map , curr , ind+1);
    }
}