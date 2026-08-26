class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0 , j = 0 , elemCnt = 0 , elem = nums[0];

        while(j < nums.length){

            if(elem == nums[j]) elemCnt++;

            else{
                elem = nums[j];
                elemCnt = 1;
            }

            if(elemCnt <= 2) nums[i++] = nums[j];

            j++;
        }

        return i;
    }
}