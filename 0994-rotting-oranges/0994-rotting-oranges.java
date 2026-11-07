class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length , n = grid[0].length;

        int[][] dir = {{-1,0} , {1,0} , {0,-1} , {0,1}};
        Queue<int[]> q = new LinkedList<>();
        
        // Initialise multi source bfs
        for(int i=0 ; i<m ; i++){
            for(int j=0 ; j<n ; j++){
                if(grid[i][j] == 2) q.offer(new int[]{i , j , 0});
            }
        }

        int minutes = 0;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            minutes = Math.max(minutes , curr[2]);

            for(int i=0 ; i<4 ; i++){
                int nr = curr[0] + dir[i][0];
                int nc = curr[1] + dir[i][1];

                if(nr < 0 || nr >= m || nc < 0 || nc >= n || grid[nr][nc] != 1) continue;

                // Mark rotten
                grid[nr][nc] = 2;
                q.offer(new int[]{nr , nc , curr[2] + 1});
            }
        }

        // Check if koi orange rotten hone se bach gya
        for(int i=0 ; i<m ; i++){
            for(int j=0 ; j<n ; j++){
                if(grid[i][j] == 1) return -1;
            }
        }

        return minutes;
    }
}