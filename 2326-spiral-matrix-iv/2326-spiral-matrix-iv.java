/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] spiral = new int[m][n];

        ListNode temp = head;
        int startRow = 0 , endRow = m-1 , startCol = 0 , endCol = n-1 , cnt = 0;

        while(cnt < m*n){

            // Move right
            if(cnt < m*n){
                
                for(int i=startCol ; i<= endCol ; i++){

                    if(temp != null){
                        spiral[startRow][i] = temp.val;
                        temp = temp.next;
                    }
                    else spiral[startRow][i] = -1;

                    cnt++;
                }
            }

            startRow++;

            // Move down
            if(cnt < m*n){

                for(int i=startRow ; i <= endRow ; i++){

                    if(temp != null){
                        spiral[i][endCol] = temp.val;
                        temp = temp.next;
                    }
                    else spiral[i][endCol] = -1;

                    cnt++;
                }
            }

            endCol--;

            // Move left
            if(cnt < m*n){

                for(int i=endCol ; i >= startCol ; i--){

                    if(temp != null){
                        spiral[endRow][i] = temp.val;
                        temp = temp.next;
                    }
                    else spiral[endRow][i] = -1;

                    cnt++;
                }  
            }     

            endRow--;

            // Move up
            if(cnt < m*n){

                for(int i=endRow ; i >= startRow ; i--){
                    
                    if(temp != null){
                        spiral[i][startCol] = temp.val;
                        temp = temp.next;
                    }
                    else spiral[i][startCol] = -1;

                    cnt++;
                }  
            } 

            startCol++;

        }

        return spiral;        
    }
}