class Solution {
    public int[][] generateMatrix(int n) {

        int[][] matrix = new int[n][n];

        int i = 0 , j = 0 , elem = 1;

        // To keep track of lastly marked element
        int[] lastVisited = new int[]{0 , 0};

        while(elem <= n*n){

            // Going left to right
            if(lastVisited[0] != 0){
                i = lastVisited[0];
                j = lastVisited[1] + 1;
            }

            while(j < n && matrix[i][j] == 0){
                matrix[i][j] = elem++;
                lastVisited[0] = i;
                lastVisited[1] = j;
                j++;
            }

            // Going up to down
            i = lastVisited[0] + 1;
            j = lastVisited[1];

            while(i < n && matrix[i][j] == 0){
                matrix[i][j] = elem++;
                lastVisited[0] = i;
                lastVisited[1] = j;
                i++;
            }

            // Going right to left
            i = lastVisited[0];
            j = lastVisited[1] - 1;

            while(j >= 0 && matrix[i][j] == 0){
                matrix[i][j] = elem++;
                lastVisited[0] = i;
                lastVisited[1] = j;
                j--;
            }

            // Going down to up
            i = lastVisited[0] - 1;
            j = lastVisited[1];

            while(i >= 0 && matrix[i][j] == 0){
                matrix[i][j] = elem++;
                lastVisited[0] = i;
                lastVisited[1] = j;
                i--;
            }
        }

        return matrix;
    }
}