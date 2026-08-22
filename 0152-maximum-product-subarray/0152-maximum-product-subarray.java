class Solution {
    public int maxProduct(int[] nums) {
        int maxProd = Integer.MIN_VALUE , suffProd = 1 , prefProd  = 1 , n = nums.length;
        
        for(int i=0 ; i<nums.length ; i++){
            
            if(prefProd == 0) prefProd = 1;
            if(suffProd == 0) suffProd = 1;

            prefProd *= nums[i];
            suffProd *= nums[n - i - 1];

            maxProd = Math.max(maxProd , Math.max(prefProd , suffProd));
        }
        
        return maxProd;
    }
}