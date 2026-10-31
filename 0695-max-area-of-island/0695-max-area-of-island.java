class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        
        int m = grid.length , n = grid[0].length;

        for(int i=0 ; i<m ; i++){
            for(int j=0 ; j<n ; j++){

                if(grid[i][j] == 1){
                    int[] currArea = new int[1];

                    solve(grid , currArea , m , n , i , j);

                    maxArea = Math.max(maxArea , currArea[0]);
                }
            }
        }

        return maxArea;
    }

    void solve(int[][] grid , int[] curr , int m , int n , int row , int col){
        
        if(row < 0 || row >= m || col < 0 || col >= n || grid[row][col] == 0) return;
        
        curr[0] += 1;
        grid[row][col] = 0;

        solve(grid , curr ,  m , n , row+1 , col);
        solve(grid , curr ,  m , n , row-1 , col);
        solve(grid , curr ,  m , n , row , col+1);
        solve(grid , curr ,  m , n , row , col-1);
    }
}