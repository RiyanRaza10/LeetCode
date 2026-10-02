class Solution {
    public int getMaximumGold(int[][] grid) {
        int[] max = new int[]{0};

        int m = grid.length , n = grid[0].length;

        for(int i = 0 ; i<m ; i++){
            for(int j=0 ; j<n ; j++){

                if(grid[i][j] != 0){
                    boolean[][] visited = new boolean[m][n];
                    visited[i][j] = true;

                    solve(grid , visited , max , grid[i][j] , m , n , i , j);

                }
            }
        }

        return max[0];
    }

    void solve(int[][] grid , boolean[][] visited , int[] max , int curr , int m , int n , int row , int col){

        max[0] = Math.max(max[0] , curr);
        
        // Check left
        if(col > 0 && !visited[row][col-1] && grid[row][col-1] > 0){

            curr += grid[row][col-1];
            visited[row][col-1] = true;

            max[0] = Math.max(max[0] , curr);

            // Recursive call
            solve(grid , visited , max , curr , m , n , row , col-1);

            // Backtrack
            curr -= grid[row][col-1];
            visited[row][col-1] = false;
        }

        // Check right
        if(col < n-1 && !visited[row][col+1] && grid[row][col+1] > 0){

            curr += grid[row][col+1];
            visited[row][col+1] = true;

            max[0] = Math.max(max[0] , curr);
            
            // Recursive call
            solve(grid , visited , max , curr , m , n , row , col+1);

            // Backtrack
            curr -= grid[row][col+1];
            visited[row][col+1] = false;
        }

        // Check up
        if(row > 0 && !visited[row-1][col] && grid[row-1][col] > 0){

            curr += grid[row-1][col];
            visited[row-1][col] = true;

            max[0] = Math.max(max[0] , curr);

            // Recursive call
            solve(grid , visited , max , curr , m , n , row-1 , col);

            // Backtrack
            curr -= grid[row-1][col];
            visited[row-1][col] = false;
        }

        // Check down
        if(row < m-1 && !visited[row+1][col] && grid[row+1][col] > 0){

            curr += grid[row+1][col];
            visited[row+1][col] = true;

            max[0] = Math.max(max[0] , curr);

            // Recursive call
            solve(grid , visited , max , curr , m , n , row+1 , col);

            // Backtrack
            curr -= grid[row+1][col];
            visited[row+1][col] = false;
        }

    }
}