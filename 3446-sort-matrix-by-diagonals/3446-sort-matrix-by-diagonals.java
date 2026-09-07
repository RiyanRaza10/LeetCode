class Solution {

    int[][] sortDiag( int [][]grid , int row , int column){
        int r = row , c = column;

        // To store diagonal elements
        List<Integer> list = new ArrayList<>();

        // Storing diagonal elements in a list
        while(r != grid.length && c != grid.length){
            list.add(grid[r++][c++]);
        }
        r = row;
        c = column;

        // Sorting the list
        Collections.sort(list);

        // For Left triangle : Sorting in reverse order
        if(column == 0){
            int ind = list.size()-1;

            while(r != grid.length && c != grid.length){
                grid[r++][c++] = list.get(ind--);
            }
        }

        // For Right triangle : Sorting in increasing order
        else{
            int ind = 0;

            while(r != grid.length && c != grid.length){
                grid[r++][c++] = list.get(ind++);
            }
        }

        return grid;
    }

    public int[][] sortMatrix(int[][] grid) {
        
        // Passing rows
        for(int i=0 ; i<grid.length ; i++){
            sortDiag(grid , i , 0);
        }

        // Passing columns
        for(int i=1 ; i<grid.length ; i++){
            sortDiag(grid , 0 , i);
        }

        return grid;
    }
}