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
        
        // Base Case
        // All rows have been visited
        if(row == n){

            // Converting board to ArrayList
            List<String> currBoard = new ArrayList<>();

            for(int i=0 ; i<n ; i++){
                currBoard.add(new String(board[i]));
            }

            validBoards.add(new ArrayList<>(currBoard));

            return;
        }

        for(int i=0 ; i<n ; i++){

            if(isSafe(board , n , row , i)){

                board[row][i] = 'Q';

                // One Queen is placed in this row , try to place in next rows
                solve(validBoards , board , n , row+1);

                // Backtrack
                board[row][i] = '.';
            }

        }
       
    }

    boolean isSafe(char[][] board , int n , int row , int col){

        // Check in same column till the current row
        for(int i=0 ; i<row ; i++){
            if(board[i][col] == 'Q') return false;
        }

        int r = row , c = col;

        // Left - Upside diagonal Check
        while(r >= 0 && c >= 0){
            if(board[r][c] == 'Q') return false;

            r--;
            c--;
        }

        r = row ; c = col;

        // Right - Upside diagonal Check
        while(r >= 0 && c < n){
            if(board[r][c] == 'Q') return false;

            r--;
            c++;
        }

        return true;

    }
}