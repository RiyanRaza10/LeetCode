class Solution {

    boolean isPossible(int[] citations , int minCitations){
        int totalPapers = 0;

        for(int i=citations.length -1 ; i>=0 ; i--){
            if(citations[i] >= minCitations){
                totalPapers++;
            }

            if(totalPapers == minCitations) break;

        }

        return totalPapers == minCitations;
        
    }

    public int hIndex(int[] citations) {
        int left = 1 , right = citations.length;

        int ans = 0;

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(isPossible(citations , mid)){
                ans = mid;
                left = mid + 1;
            }

            else right = mid - 1;
        }

        return ans;
    }
}