class Solution {

    boolean canDivide(int[] candies , long k , int maxCandies ){
        // Check how many children can get , "maxCandies" no. of candies
        long totalChildren = 0;

        for(int candy : candies){
            totalChildren += (long)Math.floor((double)candy / maxCandies );
        }

        return totalChildren >= k;
    }


    public int maximumCandies(int[] candies, long k) {
        int left = 1 , right = -1;

        for(int candy : candies){
            right = Math.max(right , candy);
        }

        int maxCandiesAChildCanGet = 0;

        while(left <= right){
            int mid = left + (right - left) / 2;

            // We can divide "mid" no. of candies among k children ,
            // distribute more to get maximum score
            if(canDivide(candies , k , mid)){
                maxCandiesAChildCanGet = mid;

                left = mid + 1;
            }

            else right = mid - 1;
        }

        return maxCandiesAChildCanGet;
    }
}