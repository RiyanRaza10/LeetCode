class Solution {
    public void solve(char[][] board) {
        int m = board.length , n = board[0].length;

        // Mark each cell that is 'O' and connected to boundary as 'B'
        for(int i=0 ; i<m ; i++){
            for(int j=0 ; j<n ; j++){
                if(board[i][j] == 'O' && (i == 0 || i == m-1 || j == 0 || j == n-1)){
                    solve(board , m , n , i , j);
                }
            }
        }

        // Mark boundary 'B' cells as 'O' and central 'O' cells as 'X'
        for(int i=0 ; i<m ; i++){
            for(int j=0 ; j<n ; j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
                else if(board[i][j] == 'B') board[i][j] = 'O';
            }
        }
    }

    void solve(char[][] board , int m , int n , int row , int col){

        if(row < 0 || row >= m || col < 0 || col >= n || board[row][col] == 'B' || board[row][col] == 'X') return;

        board[row][col] = 'B';

        solve(board , m , n , row+1 , col);
        solve(board , m , n , row-1 , col);
        solve(board , m , n , row , col+1);
        solve(board , m , n , row , col-1);
    }
}