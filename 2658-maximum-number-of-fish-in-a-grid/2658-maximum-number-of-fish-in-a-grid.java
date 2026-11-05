class Solution {
    public int findMaxFish(int[][] grid) {
        int m = grid.length , n = grid[0].length , maxFish = 0;

        for(int i=0 ; i<m ; i++){
            for(int j=0 ; j<n ; j++){

                if(grid[i][j] != 0){
                    maxFish = Math.max(maxFish , bfs(grid , m , n , i , j));
                }
            }
        }

        return maxFish;
    }

    int bfs(int[][] grid , int m , int n , int row , int col){
        int fishes = grid[row][col];

        int[] dr = {-1 , 1 , 0 , 0};
        int[] dc = {0 , 0 , -1 , 1};

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{row , col});
        grid[row][col] = 0;

        while(!q.isEmpty()){
            int[] curr = q.poll();

            for(int i=0 ; i<4 ; i++){
                int r = curr[0] + dr[i];
                int c = curr[1] + dc[i];

                if(r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == 0) continue;

                fishes += grid[r][c];
                grid[r][c] = 0;

                q.offer(new int[]{r , c});
            }
        }

        return fishes;

    }
}