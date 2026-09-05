// TC : O(log(m*n))
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length , n = matrix[0].length;

        int row = 0 , col = n - 1;

        while(row < m && col >= 0){
            int currElem = matrix[row][col];

            if(currElem == target) return true;

            else if(currElem > target) col--;

            else row++;
        }

        return false;
    }
}