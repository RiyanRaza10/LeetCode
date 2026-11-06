class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length , n = maze[0].length;

        int[] dr = {-1 , 1 , 0 , 0};
        int[] dc = {0 , 0 , -1 , 1};

        boolean[][] vis = new boolean[m][n];

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{entrance[0] , entrance[1] , 0});
        vis[entrance[0]][entrance[1]] = true;

        while(!q.isEmpty()){
            int[] curr = q.poll();

            for(int i=0 ; i<4 ; i++){
                int nr = curr[0] + dr[i];
                int nc = curr[1] + dc[i];

                // Invalid / visited
                if(nr < 0 || nr >= m || nc < 0 || nc >= n || maze[nr][nc] == '+' || vis[nr][nc]) continue;

                // Reached boundary
                if(nr == 0 || nr == m-1 || nc == 0 || nc == n-1) return 1 + curr[2];

                vis[nr][nc] = true;
                q.offer(new int[]{nr , nc , 1 + curr[2]});
            }
        }

        // No valid path
        return -1;
    }
}