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
    public ListNode partition(ListNode head, int x) {
        if(head == null) return head;

        ListNode small = new ListNode(0); // To store nodes with val < x
        ListNode smallHead = small;
        
        ListNode large = new ListNode(0); // To Store nodes wilval >= x
        ListNode largeHead = large;
        
        ListNode temp = head;

        while(temp != null){
            ListNode front = temp.next;
            temp.next = null;

            if(temp.val < x){
                small.next = temp;
                small = small.next;
            }
            else{
                large.next = temp;
                large = large.next;
            }
            
            temp = front;
        }

        smallHead = smallHead.next;
        ListNode smallTail = smallHead;

        largeHead = largeHead.next;
        if(smallTail == null) return largeHead;

        while(smallTail.next != null) smallTail = smallTail.next;

        smallTail.next = largeHead;

        return smallHead;
    }
}