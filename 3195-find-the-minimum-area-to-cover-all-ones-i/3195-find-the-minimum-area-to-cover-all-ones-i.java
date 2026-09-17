class Solution {
    public int minimumArea(int[][] grid) {
        int n = grid.length , m = grid[0].length;

        int minRow = 10000;
        int minCol = 10000;
        int maxRow = -1;
        int maxCol = -1;

        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){

                if(grid[i][j] == 1){
                    minRow = Math.min(minRow , i); // First row containing '1'
                    maxRow = Math.max(maxRow , i); // Last row containing '1'

                    minCol = Math.min(minCol , j); // First Column containing '1'
                    maxCol = Math.max(maxCol , j); // Last Column containing '1'
                }
            }
        }

        return (maxRow - minRow + 1) * (maxCol - minCol + 1);
    }
}