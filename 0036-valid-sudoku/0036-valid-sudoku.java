class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0 ; i<9 ; i++){
            for(int j=0 ; j<9 ; j++){

                if(board[i][j] != '.' && !isValid(board , board[i][j] , i , j)) return false;
                
            }
        }

        return true;
    }

    boolean isValid(char[][] board , char ch , int row , int col){

        // Checking row
        for(int i=0 ; i<9 ; i++){
            if(i != col && board[row][i] == ch) return false;

            if(i != row && board[i][col] == ch) return false;

            // Checking 3*3 box
            if(board[3 * (row / 3) + i/3][3 * (col / 3) + i%3] == ch && (row != 3 * (row / 3) + i/3 || col != 3 * (col / 3) + i%3)) return false;
        }

        return true;
    }

}