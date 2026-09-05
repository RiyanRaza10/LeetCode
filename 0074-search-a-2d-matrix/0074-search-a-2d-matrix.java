// TC : O(log(m*n))

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length , n = matrix[0].length ;
        
        int left = 0 , right = m*n - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;

            int row = mid / n;
            int col = mid % n;
            int currElem = matrix[row][col];
            
            if(currElem == target) return true;

            else if(currElem > target) right = mid - 1;

            else left = mid + 1;

        }

        return false;
    }
}

// TC : O(log(m) + log(n))

// class Solution {
//     public boolean searchMatrix(int[][] matrix, int target) {
//         int reqRow = 0;
//         int left = 0 , right = matrix.length-1;

//         // Estimating the row in which element could be found
//         while(left <= right){
//             int mid = left + (right - left) / 2;
            
//             int currElem = matrix[mid][0];

//             if(currElem == target) return true;

//             else if(currElem < target){
//                 reqRow = mid;
//                 left = mid + 1;
//             }

//             else right = mid - 1;
//         }

//         left = 0 ; right = matrix[0].length-1;

//         // Find element in the row estimated above
//         while(left <= right){
//             int mid = left + (right - left) / 2;

//             int currElem = matrix[reqRow][mid];

//             if(currElem == target) return true;

//             else if(currElem > target) right = mid - 1;

//             else left = mid + 1;
//         }

//         return false;
//     }
// }