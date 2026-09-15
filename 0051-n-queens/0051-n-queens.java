class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> allBoards = new ArrayList<>();
        StringBuilder row = new StringBuilder();
        List<String> board = new ArrayList<>();

        for(int i=0 ; i<n ; i++){
            row.append(".");
        }

        for(int i=0 ; i<n ; i++){
            board.add(row.toString());
        }

        solve(allBoards , board , n , 0);

        return allBoards;
    }

    void solve(List<List<String>> allBoards , List<String> board , int n , int row){
        
        if(row == n){
            allBoards.add(new ArrayList<>(board));

            return;
        }

        for(int i=0 ; i<n ; i++){

            if(isSafe(board , n , row , i)){

                String newRow = board.get(row).substring(0,i) + "Q" + board.get(row).substring(i+1);
                board.set(row , newRow);

                // One Queen is placed in this row , try to place in next rows
                solve(allBoards , board , n , row+1);

                // Backtrack
                board.set(row , board.get(row).substring(0,i) + "." + board.get(row).substring(i+1));
            }

        }
       
    }

    boolean isSafe(List<String> board , int n , int row , int col){

        // Check in same row
        for(int i=0 ; i<n ; i++){
            if(board.get(row).charAt(i) == 'Q') return false;
        }

        // Check in same column
        for(int i=0 ; i<n ; i++){
            if(board.get(i).charAt(col) == 'Q') return false;
        }

        int r = row , c = col;

        // Left - Upside diagonal Check
        while(r >= 0 && c >= 0){
            if(board.get(r).charAt(c) == 'Q') return false;

            r--;
            c--;
        }

        r = row ; c = col;

        // Right - Upside diagonal Check
        while(r >= 0 && c < n){
            if(board.get(r).charAt(c) == 'Q') return false;

            r--;
            c++;
        }

        r = row ; c = col;

        // Left - downside diagonal check
        while(r < n && c < n){
            if(board.get(r).charAt(c) == 'Q') return false;

            r++;
            c++;
        }

        r = row ; c = col;

        // Right - downside diagonal check
        while(r < n && c >= 0){
            if(board.get(r).charAt(c) == 'Q') return false;

            r++;
            c--;
        }

        return true;

    }
}