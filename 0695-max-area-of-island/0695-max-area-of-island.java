class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        
        int m = grid.length , n = grid[0].length;
        
        boolean[][] vis = new boolean[m][n];

        for(int i=0 ; i<m ; i++){
            for(int j=0 ; j<n ; j++){

                if(grid[i][j] == 1){
                    int[] currArea = new int[1];

                    solve(grid , vis , currArea , m , n , i , j);

                    maxArea = Math.max(maxArea , currArea[0]);
                }
            }
        }

        return maxArea;
    }

    void solve(int[][] grid , boolean[][] vis , int[] curr , int m , int n , int row , int col){
        
        if(row < 0 || row >= m || col < 0 || col >= n || grid[row][col] == 0 || vis[row][col]) return;
        
        curr[0] += 1;
        vis[row][col] = true;
        grid[row][col] = 0;

        solve(grid , vis , curr ,  m , n , row+1 , col);
        solve(grid , vis , curr ,  m , n , row-1 , col);
        solve(grid , vis , curr ,  m , n , row , col+1);
        solve(grid , vis , curr ,  m , n , row , col-1);
    }
}