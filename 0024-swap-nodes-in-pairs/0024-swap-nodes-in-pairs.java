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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode ans = new ListNode(0);;
        ListNode ansHead = ans;
        ListNode temp = head;

        while(temp != null){
            // Single node left , directly link
            if(temp.next == null){
                ans.next = temp;
                break;
            }

            
            ListNode neww = temp.next.next;
            ListNode sec = temp.next;
            ListNode curr = temp;

            sec.next = curr;
            curr.next = neww;

            ans.next = sec;
            ans = ans.next.next;

            temp = neww;
        }

        return ansHead.next;

    }
}