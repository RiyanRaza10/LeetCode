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
    public int pairSum(ListNode head) {
        int n = 0 , maxSum = 0;

        ListNode temp = head;

        // Count length of linked list
        while(temp != null){
            n++;
            temp = temp.next;
        }

        int cnt = 0;
        temp = head;

        // Move temp to lst node of left-half
        while(cnt < n/2-1){
            temp = temp.next;
            cnt++;
        }

        ListNode rev = temp.next;
        ListNode rightHalf = null;

        // Reverse right half
        while(rev != null){
            ListNode front = rev.next;
            rev.next = null;

            rev.next = rightHalf;
            rightHalf = rev;

            rev = front;
        }
        
        temp.next = rightHalf;
        temp = head;

        while(rightHalf != null){
            int currSum = temp.val + rightHalf.val;

            maxSum = Math.max(maxSum , currSum);

            temp = temp.next;
            rightHalf = rightHalf.next;
        }

        return maxSum;
    }
}