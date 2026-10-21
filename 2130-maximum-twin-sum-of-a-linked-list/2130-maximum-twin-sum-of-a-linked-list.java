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
        int n = 0;

        ListNode temp = head;

        while(temp != null){
            n++;
            temp = temp.next;
        }

        ListNode prev = null;

        temp = head;

        while(temp != null){
            ListNode neww = new ListNode(temp.val);

            neww.next = prev;
            prev = neww;

            temp = temp.next;
        }

        int cnt = 0 , maxSum = 0;
        temp = head;

        while(cnt < n/2){
            int currSum = temp.val + prev.val;

            maxSum = Math.max(maxSum , currSum);

            temp = temp.next;
            prev = prev.next;

            cnt++;
        }

        return maxSum;
    }
}