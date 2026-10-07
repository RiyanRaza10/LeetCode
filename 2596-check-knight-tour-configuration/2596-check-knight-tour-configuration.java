class Solution {
    public boolean checkValidGrid(int[][] grid) {
        // Key Idea : Start at (0,0)
        // Check if knight can visit all blocks in order
        int n = grid.length;

        boolean[][] visited = new boolean[n][n];

        // We always start at first block , no matter whether it is 0 or not
        visited[0][0] = true;

        return solve(grid , visited , 0 , 0 , n * n - 1 , 0 , n);
    }

    boolean solve(int[][] grid , boolean[][] visited , int row , int col , int lastBlock , int curr , int n){
        
        // Reached at the last block
        if(curr == lastBlock){

            // Check if all Cells are visited
            for(int i=0 ; i<n ; i++){
                for(int j=0 ; j<n ; j++){
                    if(visited[i][j] == false) return false;
                }
            }

            // All cells visited
            return true;
        }

        // Check above
        if(row > 1){
            
            // Check up left
            if(col > 0){
                if(grid[row-2][col-1] == curr + 1){
                    visited[row-2][col-1] = true;
                    if(solve(grid , visited , row - 2 , col - 1 , lastBlock , curr+1 , n)) return true;
                }
            }

            // Check up right
            if(col < n-1 && grid[row-2][col+1] == curr + 1){
                visited[row-2][col+1] = true;
                if(solve(grid , visited , row - 2 , col + 1 , lastBlock , curr + 1 , n)) return true;
            }
        }

        // Check down
        if(row < n-2){

            // Check down left
            if(col > 0 && grid[row+2][col-1] == curr + 1){
                visited[row+2][col-1] = true;
                if(solve(grid , visited , row + 2 , col - 1 , lastBlock , curr + 1 , n)) return true;
            }

            // Check down right
            if(col < n-1 && grid[row + 2][col + 1] == curr + 1){
                visited[row+2][col+1] = true;
                if(solve(grid , visited , row + 2 , col + 1 , lastBlock , curr + 1 , n)) return true;
            }
        }

        // Check left
        if(col > 1){

            // Check left upar
            if(row > 0 && grid[row-1][col - 2] == curr + 1){
                visited[row-1][col-2] = true;
                if(solve(grid , visited , row - 1 , col - 2 , lastBlock , curr + 1 , n)) return true;
            }

            // Check left neeche
            if(row < n-1 && grid[row + 1][col - 2] == curr + 1){
                visited[row+1][col-2] = true;
                if(solve(grid , visited , row + 1 , col - 2 , lastBlock , curr + 1 , n)) return true;
            }
        }

        // Check right
        if(col < n-2){

            // Check righ upar
            if(row > 0 && grid[row - 1][col + 2] == curr + 1){
                visited[row-1][col+2] = true;
                if(solve(grid , visited , row - 1 , col + 2 , lastBlock , curr + 1 , n)) return true;
            }

            // Check right neeche
            if(row < n-1 && grid[row + 1][col + 2] == curr + 1){
                visited[row+1][col+2] = true;
                if(solve(grid , visited , row + 1 , col + 2 , lastBlock , curr + 1 , n)) return true;
            }
        }

        // No valid move atp
        return false;
    }
}