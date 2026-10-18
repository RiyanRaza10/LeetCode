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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prev1 = null;
        ListNode prev2 = null;

        ListNode temp1 = l1;
        ListNode temp2 = l2;

        // Reverse l1
        while(temp1 != null){
            ListNode front = temp1.next;
            temp1.next = prev1;

            prev1 = temp1;
            temp1 = front;
        }

        // Reverse l2
        while(temp2 != null){
            ListNode front = temp2.next;
            temp2.next = prev2;

            prev2 = temp2;
            temp2 = front;
        }

        temp1 = prev1;
        temp2 = prev2;

        ListNode ans = new ListNode(0);
        ListNode temp = ans;
        int carry = 0;

        // Compute sum
        while(temp1 != null || temp2 != null || carry != 0){
            int sum = carry;

            if(temp1 != null){
                sum += temp1.val;
                temp1 = temp1.next;
            }

            if(temp2 != null){
                sum += temp2.val;
                temp2 = temp2.next;
            }

            ListNode neww = new ListNode(sum % 10);

            carry = sum / 10;

            ans.next = neww;
            ans = ans.next;
        }

        ListNode prev = null;
        temp = temp.next;

        // Reverse ans(temp)
        while(temp != null){
            ListNode front = temp.next;
            temp.next = prev;

            prev = temp;
            temp = front;
        }

        return prev;
    }
}