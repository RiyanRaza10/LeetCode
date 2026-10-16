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
    public ListNode deleteMiddle(ListNode head) {
        if(head.next == null) return head.next;

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = head;

        while(fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == null || fast.next == null){
                prev.next = slow.next;
                break;
            }
            prev = prev.next;
        }

        return head;
        
    }
}