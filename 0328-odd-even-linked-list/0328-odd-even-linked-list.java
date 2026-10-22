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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode oddHead = odd;
        ListNode evenHead = even;
        ListNode temp = head.next.next;

        odd.next = null;
        even.next = null;

        int cnt = 1;

        while(temp != null){
            if(cnt%2 == 1){
                ListNode front = temp.next;
                temp.next = null;
        
                odd.next = temp;
                odd = odd.next;

                temp = front;
            }
            else{
                ListNode front = temp.next;
                temp.next = null;

                even.next = temp;
                even = even.next;

                temp = front;
            }

            cnt++;
        }

        odd.next = evenHead;

        return oddHead;
    }
}