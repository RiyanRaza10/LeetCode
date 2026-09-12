class Solution {
    public int maximumSwap(int num) {
        char[] nums = Integer.toString(num).toCharArray();

        int n = nums.length , maxNum = 0;

        for(int i=0 ; i<n ; i++){
            char max = nums[i];
            int maxInd = -1;

            for(int j=i+1 ; j<n ; j++){
                if(nums[j] > max || (nums[j] == max && nums[j] != nums[i])){
                    max = nums[j];
                    maxInd = j;
                }
            }

            if(maxInd != -1){
                char temp = nums[i];
                nums[i] = max;
                nums[maxInd] = temp;

                break;
            }
        }

        for(char digit : nums){
            maxNum = maxNum*10 + (digit - '0');
        }

        return maxNum;
    }
}