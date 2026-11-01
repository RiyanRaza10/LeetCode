class Solution {
    public int maximumPrimeDifference(int[] nums) {
        int max = 1;

        for(int i=0 ; i<nums.length ; i++) max = Math.max(max , nums[i]);

        boolean[] isPrime = new boolean[max+1];
        Arrays.fill(isPrime , true);

        isPrime[0] = false;
        isPrime[1] = false;

        for(int i=2 ; i<=max ; i++){
            if(isPrime[i]){
                int j = 2*i;

                while(j <= max){
                    isPrime[j] = false;
                    j += i;
                }
            }
        }

        int start = -1 , end = -1;

        for(int i=0 ; i<nums.length ; i++){
            if(isPrime[nums[i]] && start == -1){
                start = i;
                end = i;
            }

            else if(isPrime[nums[i]]) end = i;
        }

        return end - start;
    }
}