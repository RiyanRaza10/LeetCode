class Solution {
    public int[] lastVisitedCell(char[][] grid) {
        int[] lastVis = new int[]{0 , 0};

        int m = grid.length , n = grid[0].length;
        int row = 0 , col = 0;

        boolean[][] vis = new boolean[m][n];

        while(true){

            if(row < 0 || row >= m || col < 0 || col >= n || vis[row][col]) break;

            vis[row][col] = true;

            lastVis[0] = row;
            lastVis[1] = col;

            char ch = grid[row][col];

            if(ch == 'L') col--;
            else if(ch == 'R') col++;
            else if(ch == 'U') row--;
            else if(ch == 'D') row++;
        }

        return lastVis;
    }
}