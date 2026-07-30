class Solution {

    int helper(int[][] mat , int sum , int i , int j , int k){
        
        for(int r = 0 ; r < mat.length ; r++){
            for(int c = 0 ; c < mat[0].length ; c++){
                if(i - k <= r && r <= i + k && j - k <= c && c <= j + k ) sum += mat[r][c];
            }
        }

        return sum;
    }

    public int[][] matrixBlockSum(int[][] mat, int k) {

        int[][] ans = new int[mat.length][mat[0].length];

        for(int i=0 ; i<mat.length ; i++){
            for(int j=0 ; j<mat[0].length ; j++){
                int sum = 0;
                ans[i][j] = helper(mat , sum , i , j , k);
            }
        }

        return ans;
    }
}