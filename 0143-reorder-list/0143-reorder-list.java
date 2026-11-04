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
    public void reorderList(ListNode head) {
        if (head.next == null)
            return;

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        ListNode left = head;

        // Find starting node of second half
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        ListNode right = null;

        // Reverse second half
        while (slow != null) {
            ListNode front = slow.next;
            slow.next = null;

            slow.next = right;
            right = slow;

            slow = front;
        }

        ListNode ans = new ListNode(0);

        while (left != null && right != null) {

            ListNode front1 = left.next;
            ListNode front2 = right.next;

            left.next = null;
            right.next = null;

            left.next = right;
            ans.next = left;
            ans = ans.next.next;

            left = front1;
            right = front2;
        }

        // In case of odd length
        if (right != null) ans.next = right;
    }
}