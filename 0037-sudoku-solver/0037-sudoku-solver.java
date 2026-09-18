class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    boolean solve(char[][] board){

        for(int i=0 ; i<9 ; i++){
            for(int j=0 ; j<9 ; j++){

                if(board[i][j] == '.'){

                    for(char ch = '1' ; ch <= '9' ; ch++){

                        if(isValid(board , ch , i , j)){
                            board[i][j] = ch;

                            if(solve(board)) return true;

                            // Backtrack
                            board[i][j] = '.'; 
                        }           
                    }

                    // Couldn't place any number at this position
                    return false;

                }

            }
        }

        return true;

    }

    boolean isValid(char[][] board , char ch , int row , int col){
        
        // Checking current row and column
        for(int i=0 ; i<9 ; i++){
            if(board[row][i] == ch) return false;

            if(board[i][col] == ch) return false;
        }

        int startRow = validate(row);
        int startCol = validate(col);

        // Checking 3*3 box
        for(int i=startRow ; i<startRow+3 ; i++){
            for(int j=startCol ; j<startCol+3 ; j++){

                if(board[i][j] == ch) return false;

            }
        }

        return true;
    }

    int validate(int rowOrCol){
        if(rowOrCol <= 2) return 0;
        else if(rowOrCol <= 5) return 3;
        return 6;
    }

}