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
    public ListNode doubleIt(ListNode head) {
        ListNode temp = head;
        ListNode revHead = null; // Stores reversed ll

        while(temp != null){
            ListNode front = temp.next;
            temp.next = revHead;

            revHead = temp;
            temp = front;
        }

        int carry = 0 , sum = 0;

        ListNode ans = new ListNode(0);
        ListNode rev = ans;
        temp = revHead;
        
        while(temp != null){
            sum = 2*temp.val + carry;

            ListNode neww = new ListNode(sum % 10);

            carry = sum / 10;

            ans.next = neww;
            ans = ans.next;

            temp = temp.next;
        }

        if(carry != 0){
            ListNode neww = new ListNode(carry);

            ans.next = neww;
            ans = ans.next;
        }

        rev = rev.next;
        ListNode prevv = null;

        // Reverse doubled ans (rev)
        while(rev != null){
            ListNode front = rev.next;
            rev.next = prevv;

            prevv = rev;
            rev = front;
        }

        return prevv;
    }
}