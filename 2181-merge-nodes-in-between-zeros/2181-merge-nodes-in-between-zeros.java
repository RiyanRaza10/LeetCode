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
    public ListNode mergeNodes(ListNode head) {
        ListNode ans = new ListNode(0);
        ListNode ansHead = ans;
        ListNode temp = head.next;

        int currSum = 0;

        while(temp != null){
            if(temp.val != 0){
                currSum += temp.val;
            }
            else{
                ListNode neww = new ListNode(currSum);

                ans.next = neww;
                ans = ans.next;

                currSum = 0;
            }    

            temp = temp.next;
        }

        return ansHead.next;
    }
}