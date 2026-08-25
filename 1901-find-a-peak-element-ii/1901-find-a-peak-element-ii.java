class Solution {

    int findMaxElemIndex(int[][] mat , int col){
        int m = mat.length , maxElem = -1 , maxElemInd = -1;

        for(int i=0 ; i<m ; i++){
            if(mat[i][col] > maxElem) {
                maxElem = mat[i][col];
                maxElemInd = i;
            }
        }

        return maxElemInd;
    }

    public int[] findPeakGrid(int[][] mat) {
        // m - rows
        // n - columns
        int m = mat.length , n = mat[0].length;

        int left = 0 , right = n-1;

        while(left <= right){
            int mid = left + (right - left) / 2;

            // Finds max element's index on the mid-th column 
            int maxElemIndex = findMaxElemIndex(mat , mid);

            int currElem = mat[maxElemIndex][mid];
            int leftElem = mid > 0 ? mat[maxElemIndex][mid-1] : -1;
            int rightElem = mid < n-1 ? mat[maxElemIndex][mid + 1] : -1;

            // Found Peak
            if(currElem > leftElem && currElem > rightElem){
                return new int[]{maxElemIndex , mid};
            }

            // Left elem is greater , eliminate right part
            else if(currElem < leftElem) right = mid - 1;

            // Right elem is greater , eliminate left part
            else left = mid + 1;

        }

        return new int[]{-1 , -1};
    }
}