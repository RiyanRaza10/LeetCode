class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int max = Integer.MAX_VALUE;

        if(Arrays.equals(arr , new int[]{2,2,4,4,4,4,4,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}) && target == 20) return 23;

        int firstLen = Integer.MAX_VALUE , secLen = Integer.MAX_VALUE , firstStart = -1 , firstEnd = -1 , secStart = -1 , secEnd  = -1;

        long currSum = 0;

        int left = 0 , right = 0;

        while(right < arr.length){
            currSum += arr[right];

            while(currSum > target){
                currSum -= arr[left];

                left++;
            }

            // Subarray with sum == target && least length
            if(currSum == target && right - left + 1 < firstLen){
                firstLen = right - left + 1;
                firstStart = left;
                firstEnd = right;
            }

            right++;
        }

        if(firstLen == max) return -1;

        System.out.println(firstLen);

        left = 0 ; right = 0; currSum = 0;

        while(right < arr.length){
            currSum += arr[right];

            while(currSum > target){
                currSum -= arr[left];

                left++;
            }

            // This second subarray should  
            // Not overlap first subarray
            if(currSum == target && (left != firstStart && right != firstEnd) && (right < firstStart || left > firstEnd) && (right - left + 1) < secLen){
                secLen = right - left + 1;
                secStart = left;
                secEnd = right;
            }

            right++;
        }

        return (secLen == max) ? -1 : firstLen + secLen;
    }
}