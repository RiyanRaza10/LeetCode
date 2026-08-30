class Solution {

    boolean isPossible(int[] citations , int minCitations){
        int totalPapers = 0;

        for(int citation : citations){
            if(citation >= minCitations){
                totalPapers++;
            }

            // No need to further check
            if(totalPapers == minCitations) break;
        }

        return totalPapers == minCitations;

    }

    public int hIndex(int[] citations) {
        int left = 1 , right = citations.length , max = 0;

        while(left <= right){
            int mid = left + (right - left) / 2;

            // Check if "mid" no. of papers have at least "mid" citations 
            if(isPossible(citations , mid)){
                max = mid;

                left = mid + 1;
            }

            else right = mid - 1;

        }

        return max;
    }
}