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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;

        int len = 0;
        ListNode temp = head;

        while(temp != null){
            len++;
            temp = temp.next;
        }

        // Avoid unnecessary rotations
        k %= len;
        if(k % len == 0) return head;

        int leftPart = len - k;

        ListNode prev1 = null;
        temp = head;

        int cnt = 0;

        // Reverse first len-k nodes and store in prev1
        while(cnt++ < leftPart){
            ListNode front = temp.next;
            temp.next = null;

            temp.next = prev1;
            prev1 = temp;

            temp = front;
        }

        ListNode prev2 = null;

        // Reverse last k nodes and store in prev2
        while(temp != null){
            ListNode front = temp.next;
            temp.next = null;

            temp.next = prev2;
            prev2 = temp;

            temp = front;
        } 

        temp = prev1;
        
        // Find last node of prev1
        while(temp.next != null){
            temp = temp.next;
        }

        // Join prev2 to prev1
        temp.next = prev2;

        temp = prev1;
        ListNode rev = null;

        // Reverse prev1
        while(temp != null){
            ListNode front = temp.next;
            temp.next = null;

            temp.next = rev;
            rev = temp;
            temp = front;
        }

        return rev;
    }
}