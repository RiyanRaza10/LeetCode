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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode prev1 = list1;
        int cnt = 1;

        // Find last node of list1 which is relevant (a-th node of list1){0 - indexed}
        while(prev1 != null){
            if(cnt == a) break;
            
            cnt++;
            prev1 = prev1.next;
        }

        ListNode tail1 = list1;
        cnt = 0;

        // Find head of tail of list1 which is relevant ((b+1)th node of list1)
        while(tail1 != null){
            if(cnt == b){
                ListNode nextt = tail1.next;
                tail1.next = null;
                tail1 = nextt;
                break;
            }

            cnt++;
            tail1 = tail1.next;
        }

        ListNode tail2 = list2;

        // Find tail of list2
        while(tail2.next != null) tail2 = tail2.next;

        prev1.next = list2;
        tail2.next = tail1;

        return list1;
    }
}