class Solution {

    int findPeak(int[][] mat , int row){
        int n = mat[row].length;

        for(int j=0 ; j<mat[row].length ; j++){
            boolean left = false , right = false , up = false , down = false;

            // Verify left and right elem
            left = (j > 0) ? mat[row][j] > mat[row][j-1] : true;
            right = (j != n-1) ? mat[row][j] > mat[row][j+1] : true;

            // Verify up and down element
            up = (row == 0) ? true : mat[row][j] > mat[row-1][j];
            down = (row == mat.length-1) ? true : mat[row][j] > mat[row+1][j];

            // Peak found
            if(left && right && up && down) return j;

        }

        return -1;
    }
    
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length , n = mat[0].length;

        for(int i=0 ; i<m ; i++){
            
            int ans = findPeak(mat , i);

            if(ans != -1) return new int[]{i , ans};

        }

        return new int[]{-1 , -1};
    }
}