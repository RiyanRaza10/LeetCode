class Solution {
    public List<List<Integer>> findDisappearedNumbers(int[] nums, int lower, int upper) {
        List<List<Integer>> list = new ArrayList<>();

        HashSet<Integer> set = new HashSet<>();

        for(int val : nums) set.add(val);

        int start = 0 , end = 0;

        for(int i=lower ; i <= upper ; i++){

            if(!set.contains(i)){
                if(start == 0) start = i;

                else end = i;
            }

            else{
                if(start != 0) end = i-1;

                if(start != 0) list.add(Arrays.asList(start , end));

                start = 0 ;
                end = 0;
            }

        }

        if(start != 0){
            end = upper;
            list.add(Arrays.asList(start , end));
        }

        return list;
    }
}