class Solution {
    public int[] findDiagonalOrder(int[][] mat) {

        int ind = 0 , i = 0 , j = 0 , m = mat.length , n = mat[0].length;

        // To store answer
        int[] ans = new int[n * m];

        // To store lastVisited diagonal  
        int[] upwardStart = new int[]{0,0} , downwardStart = new int[]{0,1};

        while(ind < m * n){

            // Upward loop
            i = upwardStart[0];
            j = upwardStart[1];
            
            while( i >= 0 && j < n){
                if(i < m && j >= 0 && ind < m*n) ans[ind++] = mat[i][j];
                i-- ; j++;
            }

            // Diagonals before the edge
            if(upwardStart[0] + 2  < m){
                upwardStart[0] += 2;
            }

            // Diagonal just before the edge
            else if(upwardStart[0] == m-1){
                upwardStart[1] += 2;
            }

            // Edge Diagonal
            else if(upwardStart[0] == m-2){
                upwardStart[0] += 1;
                upwardStart[1] += 1;
            }
            
            // Downward loop
            i = downwardStart[0];
            j = downwardStart[1];

            int cnt = 0;
            while(i < m && j >= 0){
                if(i >= 0 && j < n && i < m && j >= 0 && ind < m*n){
                    // Checking first starting element of diagonal
                    if(cnt == 0){
                        downwardStart[0] = i;
                        downwardStart[1] = j;
                        cnt++;
                    }
                    ans[ind++] = mat[i][j];
                }
                i++;
                j--;
            }

            // Diagonals before the edge
            if(downwardStart[1] + 2 < n){
                downwardStart[1] += 2;
            }

            // Diagonal just before the edge
            else if(downwardStart[1] == n-1){
                downwardStart[0] += 2;
            }

            // Edge diagonal
            else if(downwardStart[1] == n-2){
                downwardStart[0] += 1;
                downwardStart[1] += 1;
            }

        }

        return ans;
    }
}