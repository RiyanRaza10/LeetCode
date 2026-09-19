class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> validBoards = new ArrayList<>();

        char[][] board = new char[n][n];

        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<n ; j++){
                board[i][j] = '.';
            }
        }

        solve(validBoards , board , n , 0);

        return validBoards;
    }

    void solve(List<List<String>> validBoards , char[][] board , int n , int row){

        // All Queens placed
        if(row == n){

            // Converting char[][] to list
            List<String> currBoard = new ArrayList<>();

            for(int i=0 ; i<n ; i++){
                currBoard.add(new String(board[i]));
            }

            validBoards.add(new ArrayList<>(currBoard));

            return;
        }

        for(int col=0 ; col<n ; col++){

            // Check if we can place a queen at this position
            if(isValid(board , row , col)){
                board[row][col] = 'Q';

                // Recursive call
                solve(validBoards , board , n , row+1);

                // Backtrack
                board[row][col] = '.';
            }

        }
    }

    boolean isValid(char[][] board , int row , int col){

        // Check in same column till curr row
        for(int i=0 ; i<row ; i++){
            if(board[i][col] == 'Q') return false;
        }

        int r = row , c = col;

        // Check in left - upside diagonal
        while(r >= 0 && c >= 0){
            if(board[r][c] == 'Q') return false;

            r--;
            c--;
        }

        r = row;
        c = col;

        // Check in right - upside diagonal
        while(r >= 0 && c <= board.length-1){
            if(board[r][c] == 'Q') return false;

            r--;
            c++;
        }

        return true;
    }
}