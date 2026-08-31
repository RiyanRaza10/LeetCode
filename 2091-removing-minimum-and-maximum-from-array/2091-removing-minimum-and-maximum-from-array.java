class Solution {
    public int minimumDeletions(int[] nums) {

        if(nums.length == 1) return 1;

        int n = nums.length , maxElem = -1000000 , minElem = 1000000 , minElemInd = -1 , maxElemInd = -1;

        for(int i=0 ; i<n ; i++){
            if(nums[i] > maxElem){
                maxElemInd = i;
                maxElem = nums[i];
            }

            if(nums[i] < minElem){
                minElem = nums[i];
                minElemInd = i;
            }
        }

        // Variable names to remove both elements from :
        int removeFromStart = Math.max(maxElemInd , minElemInd) + 1;
        int removeFromEnd = n - Math.min(maxElemInd , minElemInd);
        int removeFromBothEnd = (Math.min(minElemInd , maxElemInd) + 1) + (n - Math.max(minElemInd , maxElemInd));

        // Check which operation requires less operations
        return Math.min(removeFromBothEnd , Math.min(removeFromStart , removeFromEnd));

    }
}