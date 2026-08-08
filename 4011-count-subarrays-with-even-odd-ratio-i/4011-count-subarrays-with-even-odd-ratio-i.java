class Solution {
    public int countRatioSubarrays(int[] nums, int a, int b) {
        int cnt = 0 ;

        double ratio = (double)a/b;
        
        for(int i=0 ; i<nums.length ; i++){
            int x = 0 , y = 0;

            for(int j=i ; j<nums.length ; j++){
                if(nums[j] % 2 == 0) x++;
                else y++;

                if(y > 0 && (double)x/y <= ratio) cnt++;
            }
        }

        return cnt;
    }
}