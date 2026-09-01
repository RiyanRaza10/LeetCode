// Optimised log(n) solution

class Solution {
    public int hIndex(int[] citations) {
        int left = 0 , right = citations.length-1 , n = citations.length;

        int ans = 0;

        while(left <= right){
            int mid = left + (right - left) / 2;

            // Valid Citation found, search larger
            // n - mid = total research papers from last till index mid
            if(citations[mid] >= n - mid){
                ans = n - mid;
                right = mid - 1;
            }

            else left = mid + 1;
        }

        return ans;
    }
}
