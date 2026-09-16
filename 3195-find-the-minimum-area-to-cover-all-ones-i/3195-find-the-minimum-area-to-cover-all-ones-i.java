class Solution {
    public int minimumArea(int[][] grid) {
        int upper = 0 , lower = grid.length-1 , left = 0 , right = grid[0].length-1;

        // First row containing '1'
        for(int i=0 ; i<grid.length ; i++){
            int sum = 0;
            for(int j=0 ; j<grid[i].length ; j++){
                sum += grid[i][j];
            }

            if(sum != 0) break;

            upper++;
        }

        // Last row containing '1'
        for(int i=grid.length-1 ; i>=0 ; i--){
            int sum = 0;
            for(int j=0 ; j<grid[i].length ; j++){
                sum += grid[i][j];
            }

            if(sum != 0) break;

            lower--;
        }

        // First Column containing '1'
        for(int i=0 ; i<grid[0].length ; i++){
            int sum = 0;
            for(int j=0 ; j<grid.length ; j++){
                sum += grid[j][i];
            }

            if(sum != 0) break;

            left++;
        }

        // Last Column containing '1'
        for(int i=grid[0].length-1 ; i>=0 ; i--){
            int sum = 0;
            for(int j=0 ; j<grid.length ; j++){
                sum += grid[j][i];
            }

            if(sum != 0) break;

            right--;
        }

        return (right - left + 1) * (lower - upper + 1);
    }
}