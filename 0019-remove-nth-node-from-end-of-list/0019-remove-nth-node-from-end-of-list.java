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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;

        ListNode temp = head;

        while(temp != null) {
            len++;
            temp = temp.next;
        }

        int nodeNumber = len - n + 1;
        int cnt = 1;

        // Handle first node
        if(nodeNumber == 1){
            head = head.next;
            return head;
        }   

        ListNode prev = null;
        temp = head;

        while(temp != null){
            if(cnt == nodeNumber){
                prev.next = prev.next.next;
                break;
            }

            prev = temp;
            temp = temp.next;
            cnt++;
        }

        return head;

    }
}