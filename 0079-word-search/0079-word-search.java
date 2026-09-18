class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length , m = board[0].length;

        boolean[][] visited = new boolean[n][m];

        for(int i=0  ; i<n ; i++){
            for(int j=0 ; j<m ; j++){

                if(word.charAt(0) == board[i][j]){
                    visited[i][j] = true;

                    if(searchWord(board , word , visited , i , j , 1)) return true;

                    // Backtrack
                    visited[i][j] = false;
                
                }
            }
        }
        
        // Word not found
        return false;
    }

    boolean searchWord(char[][] board , String word , boolean[][] visited , int row , int col , int ind){
        
        // Word found
        if(ind == word.length()){
            return true;
        }

        // Check left
        if(col > 0 && !visited[row][col-1] && word.charAt(ind) == board[row][col-1]){
            visited[row][col-1] = true;

            if(searchWord(board , word , visited , row , col-1 , ind+1)) return true;

            // Backtrack
            visited[row][col-1] = false;
        }

        // Check right
        if(col < board[0].length-1 && !visited[row][col+1] && word.charAt(ind) == board[row][col+1]){
            visited[row][col+1] = true;

            if(searchWord(board , word , visited , row , col+1 , ind+1)) return true;

            // Backtrack
            visited[row][col+1] = false;
        }

        // Check up
        if(row > 0 && !visited[row-1][col] && word.charAt(ind) == board[row-1][col]){
            visited[row-1][col] = true;

            if(searchWord(board , word , visited , row-1 , col , ind+1)) return true;

            // Backtrack
            visited[row-1][col] = false;
        }

        // Check down
        if(row < board.length-1 && !visited[row+1][col] && word.charAt(ind) == board[row+1][col]){
            visited[row+1][col] = true;

            if(searchWord(board , word , visited , row+1 , col , ind+1)) return true;

            visited[row+1][col] = false;
        }

        // No matching character found
        return false;
        
    }
}