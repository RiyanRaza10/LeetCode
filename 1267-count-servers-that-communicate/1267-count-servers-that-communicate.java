class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length , n = grid[0].length , res = 0;

        int[] rowCnt = new int[m] , colCnt = new int[n];

        // Count servers in each row
        for(int i=0 ; i<m ; i++){
            int servers = 0;

            for(int j=0 ; j<n ; j++){
                if(grid[i][j] == 1) servers++;
            }

            rowCnt[i] = servers;
        }

        // Count servers in each col
        for(int i=0 ; i<n ; i++){
            int servers = 0;

            for(int j=0 ; j<m ; j++){
                if(grid[j][i] == 1) servers++;
            }

            colCnt[i] = servers;
        }

        // Count servers that have at least 1 extra server in their row or col
        for(int i=0 ; i<m ; i++){
            for(int j=0 ; j<n ; j++){
                if(grid[i][j] == 1) res += (rowCnt[i] > 1 || colCnt[j] > 1) ? 1 : 0;
            }
        }

        return res;
    }
}