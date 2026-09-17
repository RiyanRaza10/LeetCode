class Solution {
    public int minimumSum(int[][] grid) {
        int n = grid.length , m = grid[0].length , minArea = Integer.MAX_VALUE;

        // Case : 1
        // 3 Horizontal Rectangles
        for(int i=0 ; i<n ; i++){
            for(int j=i+1 ; j<n-1 ; j++){

                minArea = Math.min(minArea , calcArea(grid , 0 , i , 0 , m-1) + calcArea(grid , i+1 , j , 0 , m-1) + calcArea(grid , j+1 , n-1, 0, m-1));

            }
        }

        // Case : 2
        // 3 Vertical Rectangles
        for(int i=0 ; i<m ; i++){
            for(int j=i+1 ; j<m-1 ; j++){

                minArea = Math.min(minArea , calcArea(grid , 0 , n-1, 0 , i) + calcArea(grid , 0 , n-1, i+1, j) + calcArea(grid , 0 , n-1 , j+1 , m-1));
            
            }
        }

        // Case : 3
        // 1 Horizontal Rectangle from top
        // 2 Vertical Rectangles
        for(int i=0 ; i<n-1 ; i++){
            for(int j=0 ; j<m-1 ; j++){

            minArea = Math.min(minArea , calcArea(grid , 0 , i , 0 , m-1) + calcArea(grid , i+1 , n-1, 0 , j) + calcArea(grid , i+1 , n-1 , j+1 , m-1));

            }
        }

        // Case : 4
        // 2 Vertical Rectangles
        // 1 Horizontal Rectangle from bottom
        for(int i=n-1 ; i>0 ; i--){
            for(int j=0 ; j<m-1 ; j++){

            minArea = Math.min(minArea , calcArea(grid , i , n-1 , 0 , m-1) + calcArea(grid , 0 , i-1 , 0 , j) + calcArea(grid , 0 , i-1 , j+1 , m-1));

            }
        }

        // Case : 5
        // 1 Vertical Rectangle from left
        // 2 Horizontal Rectangles
        for(int i=0 ; i<m-1 ; i++){
            for(int j=0 ; j<n-1 ; j++){

            minArea = Math.min(minArea , calcArea(grid , 0 , n-1 , 0 , i) + calcArea(grid , 0 , j , i+1 , m-1) + calcArea(grid , j+1 , n-1 , i+1 , m-1));

            }
        }

        // Case : 6
        // 2 Horizontal Rectangles
        // 1 Vertical Rectangle from right
        for(int i=m-1 ; i>0 ; i--){
            for(int j=0 ; j<n-1 ; j++){

            minArea = Math.min(minArea , calcArea(grid , 0 , n-1 , i , m-1) + calcArea(grid , 0 , j , 0 , i-1) + calcArea(grid , j+1 , n-1 , 0 , i-1));

            }
        }     

        return minArea;

    }

    // This Function finds a minimum Rectangular area covering all '1's
    int calcArea(int[][] grid , int startRow , int endRow , int startCol , int endCol){
        int n = grid.length , m = grid[0].length;

        int minRow = 1000;
        int minCol = 1000;
        int maxRow = -1;
        int maxCol = -1;

        for(int i=startRow ; i<=endRow ; i++){
            for(int j=startCol ; j<=endCol ; j++){

                if(grid[i][j] == 1){
                    minRow = Math.min(minRow , i); // First row containing '1'
                    maxRow = Math.max(maxRow , i); // Last row containing '1'

                    minCol = Math.min(minCol , j); // First Column containing '1'
                    maxCol = Math.max(maxCol , j); // Last Column containing '1'
                }
            }
        }

        return (maxRow - minRow + 1) * (maxCol - minCol + 1);
    }
}