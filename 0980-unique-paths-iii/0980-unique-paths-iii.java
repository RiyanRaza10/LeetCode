class Solution {
    public int uniquePathsIII(int[][] grid) {
        // Key Idea : Calculate all  paths from starting cell to ending cell
        //            such that all empty cells are visited
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int[] maxPaths = new int[1];

        int emptyGrids = 0, startRow = 0, startCol = 0;

        // Calculate total Empty boxes and start box
        for (int i = 0 ; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) emptyGrids++;
                
                else if (grid[i][j] == 1) {
                    startRow = i;
                    startCol = j;
                }
            }
        }

        visited[startRow][startCol] = true;

        // Pass emptyGrids as emptyGrids + startingCell + endingCell
        solve(grid, visited, maxPaths, m, n, emptyGrids + 2 , 1 , startRow, startCol);

        return maxPaths[0];
    }

    void solve(int[][] grid, boolean[][] visited, int[] maxPaths, int m, int n, int emptyGrids, int currGrids, int row,
            int col) {

        // Reached ending box
        if (grid[row][col] == 2) {
            if (currGrids == emptyGrids)
                maxPaths[0]++;

            return;
        }

        // Check up
        if (row > 0 && row < m && col >= 0 && col < n && !visited[row - 1][col] && grid[row - 1][col] != -1) {
            visited[row - 1][col] = true;

            solve(grid, visited, maxPaths, m, n, emptyGrids, currGrids + 1, row - 1, col);

            visited[row - 1][col] = false;
        }

        // Check down
        if (row >= 0 && row < m - 1 && col >= 0 && col < n && !visited[row + 1][col] && grid[row + 1][col] != -1) {
            visited[row + 1][col] = true;

            solve(grid, visited, maxPaths, m, n, emptyGrids, currGrids + 1, row + 1, col);

            visited[row + 1][col] = false;
        }

        // Check left
        if (row >= 0 && row < m && col > 0 && col < n && !visited[row][col - 1] && grid[row][col - 1] != -1) {
            visited[row][col - 1] = true;

            solve(grid, visited, maxPaths, m, n, emptyGrids, currGrids + 1, row, col - 1);

            visited[row][col - 1] = false;
        }

        // Check right
        if (row >= 0 && row < m && col >= 0 && col < n - 1 && !visited[row][col + 1] && grid[row][col + 1] != -1) {
            visited[row][col + 1] = true;

            solve(grid, visited, maxPaths, m, n, emptyGrids, currGrids + 1, row, col + 1);

            visited[row][col + 1] = false;
        }
    }
}