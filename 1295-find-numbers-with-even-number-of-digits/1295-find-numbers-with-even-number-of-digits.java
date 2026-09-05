class Solution {
    public int findNumbers(int[] nums) {
        int evenCnt = 0;
        
        for(int val : nums){
            int digitCnt = 0;

            while(val > 0){
                val /= 10;
                digitCnt++;
            }

            if((digitCnt & 1) == 0) evenCnt++;
        }

        return evenCnt;
    }
}