class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length , n = grid[0].length , islands = 0;

        boolean[][] visited = new boolean[m][n];

        for(int i = 0 ; i<m ; i++){
            for(int j=0 ; j<n ; j++){

                if(grid[i][j] == '1' && !visited[i][j]){
                    islands++;

                    solve(grid , visited , m , n , i , j);
                }
            }
        }   

        return islands;
    }

    void solve(char[][] grid , boolean[][] visited , int m , int n , int row , int col){

        if(row < 0 || row >= m || col < 0 || col >= n || visited[row][col] || grid[row][col] == '0') return;

        // Mark visited
        visited[row][col] = true;
        
        solve(grid , visited , m , n , row+1 , col);
        solve(grid , visited , m , n , row-1 , col);
        solve(grid , visited , m , n , row , col+1);
        solve(grid , visited , m , n , row , col-1);
    }
}