class Solution {

    boolean canDistribute(int n , int[] quantities , int maxNoOfProducts){
        int totalStores = 0;

        for(int q : quantities){
            totalStores += (int)Math.ceil((double)q / maxNoOfProducts);
        }

        return totalStores <= n ;
    }

    public int minimizedMaximum(int n, int[] quantities) {
        int left = 1 , right = 0 , minX = 1;

        for(int q : quantities) right = Math.max(right , q);

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(canDistribute(n , quantities , mid)){
                right = mid - 1;

                minX = mid;
            }

            else left = mid + 1;
        }

        return minX;
    }
}