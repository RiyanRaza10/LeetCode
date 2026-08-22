class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        List<Integer> list = new ArrayList<>();

        int cnt1 = 0 , cnt2 = 0 , elem1 = Integer.MIN_VALUE , elem2 = Integer.MIN_VALUE;

        for(int i=0 ; i<nums.length ; i++){

            // Assign nums[i] to elem1
            if(cnt1 == 0 && nums[i] != elem2){
                cnt1++;
                elem1 = nums[i];
            }

            // Assign nums[i] to elem2
            else if(cnt2 == 0 && nums[i] != elem1){
                cnt2++;
                elem2 = nums[i];
            }

            // Increment freq if found
            else if(nums[i] == elem1) cnt1++;
            else if(nums[i] == elem2) cnt2++;

            // Different element found , decrement freq
            else{
                cnt1--;
                cnt2--;
            }

        }

        // Verify
        cnt1 = 0 ; cnt2 = 0;

        for(int val : nums){
            if(val == elem1) cnt1++;
            else if(val == elem2) cnt2++;
        }

        if(cnt1 > nums.length/3) list.add(elem1);
        if(cnt2 > nums.length/3) list.add(elem2);

        return list;
    }
}