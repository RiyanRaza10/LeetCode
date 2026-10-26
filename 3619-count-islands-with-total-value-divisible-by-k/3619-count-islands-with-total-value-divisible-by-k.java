class Solution {
    public int countIslands(int[][] grid, int k) {
        int m = grid.length , n = grid[0].length;
        int islands = 0;

        for(int i=0 ; i<m ; i++){
            for(int j=0 ; j<n ; j++){
                if(grid[i][j] != 0){
                    long[] curr = new long[1];
                    solve(grid , curr , m , n , i , j);

                    if(curr[0] % k == 0) islands++;
                }
            }
        }

        return islands;
    }

    void solve(int[][] grid , long[] curr , int m , int n , int row , int col){

        if(row < 0 || row >= m || col < 0 || col >= n || grid[row][col] == 0) return;

        curr[0] += grid[row][col];
        grid[row][col] = 0;

        solve(grid , curr , m , n , row+1 , col);
        solve(grid , curr , m , n , row-1 , col);
        solve(grid , curr , m , n , row , col+1);
        solve(grid , curr , m , n , row , col-1);
    }
}