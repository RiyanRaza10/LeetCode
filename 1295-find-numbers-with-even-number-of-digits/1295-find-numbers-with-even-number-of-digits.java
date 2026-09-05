class Solution {
    public int findNumbers(int[] nums) {
        int evenCnt = 0;
        
        for(int val : nums){
           if( (((val + "").length()) & 1) == 0 ) evenCnt++;
        }

        return evenCnt;
    }
}