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
        ListNode slow = head;
        ListNode fast = head;

        // Count length of linked list
        while(fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // Slow is at the last node of left-half

        ListNode prev = slow.next;
        ListNode rightHalf = null;

        // Reverse right half
        while(prev != null){
            ListNode front = prev.next;
            prev.next = null;

            prev.next = rightHalf;
            rightHalf = prev;

            prev = front;
        }

        ListNode leftHalf = head;
        int maxSum = 0;

        while(rightHalf != null){
            int currSum = leftHalf.val + rightHalf.val;

            maxSum = Math.max(maxSum , currSum);

            leftHalf = leftHalf.next;
            rightHalf = rightHalf.next;
        }

        return maxSum;
    }
}