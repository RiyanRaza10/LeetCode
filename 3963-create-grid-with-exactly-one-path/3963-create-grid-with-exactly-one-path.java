class Solution {
    public String[] createGrid(int m, int n) {
        StringBuilder firstRow = new StringBuilder();
        StringBuilder secRow = new StringBuilder();
        
        for(int i=0 ; i<n ; i++) firstRow.append(".");
        for(int i=0 ; i<n-1 ; i++) secRow.append("#");
        secRow.append(".");

        String[] grid = new String[m];

        for(int i=0 ; i<m ; i++){
            grid[i] = "";
            if(i == 0) grid[i] = firstRow.toString();
            else grid[i] = secRow.toString();
        }

        return grid;
    }   
}