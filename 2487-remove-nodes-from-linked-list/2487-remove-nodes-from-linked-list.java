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
    public ListNode removeNodes(ListNode head) {
        if(head.next == null) return head;

        Deque<ListNode> dq = new ArrayDeque<>();
        ListNode temp = head;

        while(temp != null){
            ListNode front = temp.next;
            temp.next = null;

            while(!dq.isEmpty() && dq.peekLast().val < temp.val) dq.pollLast();
            dq.offerLast(temp);

            temp = front;
        }

        if(dq.isEmpty()) return null;

        ListNode ansHead = dq.peekFirst();
        temp = dq.pollFirst();
        
        while(!dq.isEmpty()){
            temp.next = dq.pollFirst();
            temp = temp.next;
        }

        return ansHead;
    }
}