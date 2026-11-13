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
        ListNode temp = head;

        while(temp != null){
            ListNode front = temp.next;
            temp.next = null;

            temp.next = prev;
            prev = temp;

            temp = front;
        }

        return prev;
    }
    
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode prev = null;
        ListNode temp = head;
        int ind = 1;

        while(temp != null){
            if(ind == left){
                if(prev != null) prev.next = null;
                ListNode start = temp;

                while(ind < right){
                    temp = temp.next;
                    ind++;
                }

                ListNode nextt = temp.next;
                temp.next = null;
                
                ListNode reversed = reverse(start , null);

                // If there exist some nodes before left
                if(prev != null){
                    prev.next = reversed;
                    prev = head;
                }

                // In case starting node is left
                else prev = reversed;

                // reach to last node of reversed , and append nextt
                while(reversed.next != null) reversed = reversed.next;
                
                reversed.next = nextt;

                break;
            }

            prev = temp;
            temp = temp.next;
            ind++;
        }

        return prev;
    }
}