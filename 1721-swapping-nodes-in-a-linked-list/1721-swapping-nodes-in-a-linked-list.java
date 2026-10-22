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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode temp = head;

        ListNode frontK = null;
        ListNode lastK = null;

        int len = 1;

        // Find length of ll and front kth node
        while(temp != null){
            if(len == k) frontK = temp;

            len++;
            temp = temp.next;
        }

        int lastKthPos = len - k;
        int currPos = 1;

        temp = head;

        // Find last kth node
        while(temp != null){
            if(currPos == lastKthPos){
                lastK = temp;
                break;
            }

            currPos++;
            temp = temp.next;
        }

        // Swap values
        int tempp = frontK.val;
        frontK.val = lastK.val;
        lastK.val = tempp;

        return head;

    }
}