class Solution {
    int cnt = 0;

    public int numEnclaves(int[][] grid) {
        int m = grid.length , n = grid[0].length;

        for(int i=0 ; i<m ; i++){
            for(int j=0 ; j<n ; j++){
                if((i == 0 || j == 0 || i == m-1 || j == n-1) && grid[i][j] == 1){
                    dfs(grid , m , n , i , j);
                }
            }
        }

        cnt = 0;

        for(int i=0 ; i<m ; i++){
            for(int j=0 ; j<n ; j++){
                if(grid[i][j] == 1){
                    dfs(grid , m , n , i , j);
                }
            }
        }

        return cnt;
    }

    void dfs(int[][] grid , int m , int n , int row , int col){

        if(row < 0 || row >= m || col < 0 || col >= n || grid[row][col] == 0) return;

        grid[row][col] = 0;
        cnt++;

        dfs(grid , m , n , row+1 , col);
        dfs(grid , m , n , row-1 , col);
        dfs(grid , m , n , row , col+1);
        dfs(grid , m , n , row , col-1);
    }
}