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

    ListNode reverse(ListNode head , ListNode prev){
        if(head == null) return prev;

        ListNode front = head.next;
        head.next = null;

        head.next = prev;
        prev = head;

        head = front;

        return reverse(head , prev);
    }

     public ListNode reverseKGroup(ListNode head, int k) {
        ListNode ans = new ListNode(0);
        ListNode ansHead = ans;
        ListNode temp = head;

        while(temp != null){
            int cnt = 1;

            ListNode prev = temp;
            ListNode last = temp;

            while(cnt < k && last != null){
                last = last.next;
                cnt++;
            }

            if(cnt == k && last != null){
                temp = last.next;
                last.next = null;

                ans.next = reverse(prev , null);
                
                // Reach to last node of ans
                while(ans.next != null) ans = ans.next;
            }

            else{
                ans.next = prev;
                break;
            }
        }

        return ansHead.next;
    }
}