class Solution {
    public int totalNQueens(int n) {
        int[] validBoards = new int[1];

        char[][] board = new char[n][n];

        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<n ; j++){
                board[i][j] = '.';
            }
        }

        solve(board , validBoards , n , 0);

        return validBoards[0];
    }

    void solve(char[][] board , int[] validBoards , int n , int row){

        // All Queens placed
        if(row == n){
            validBoards[0] += 1;

            return;
        }

        for(int col = 0 ; col < n ; col++){

            // Check if we can place a queen at this position
            if(isSafe(board , row , col)){
                board[row][col] = 'Q';

                // Recursive call to next row
                solve(board , validBoards , n , row+1);

                // Backtrack
                board[row][col] = '.';
            }
        }
    }

    boolean isSafe(char[][] board , int row , int col){

        // Check in same column till current row
        for(int i=0 ; i<row ; i++){
            if(board[i][col] == 'Q') return false;
        }

        int r = row , c = col;

        // Check in left - upright diagonal
        while(r >= 0 && c >= 0){
            if(board[r][c] == 'Q') return false;

            r--;
            c--;
        }

        r = row;
        c = col;

        // Check in right - upright diagonal
        while(r >= 0 && c <= board.length-1){
            if(board[r][c] == 'Q') return false;

            r--;
            c++;
        }

        // Safe to place
        return true;
    }
}