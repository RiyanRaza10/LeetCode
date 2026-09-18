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
        }

        // Checking col
        for(int i=0 ; i<9 ; i++){
            if(i != row && board[i][col] == ch) return false;
        }

        int startRow = validate(row);
        int startCol = validate(col);

        // Checking 3*3 box
        for(int i=startRow ; i<startRow+3 ; i++){
            for(int j=startCol ; j<startCol+3 ; j++){
                
                if((i != row || j != col) && board[i][j] == ch) return false;

            }
        }

        return true;
    }

    int validate(int rowOrCol){
        if(rowOrCol <= 2) return 0;
        else if(rowOrCol <= 5) return 3;
        else return 6;
    }

}