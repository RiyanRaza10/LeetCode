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
    
    int gcd(int x , int y){
        if(y == 0) return x;
        return gcd(y , x%y);
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head.next == null) return head;

        ListNode temp = head;

        while(temp != null){
            if(temp.next == null){
                break;
            }

            ListNode sec = temp.next;
            ListNode neww = new ListNode(gcd(temp.val , sec.val));

            temp.next = neww;
            neww.next = sec;
            temp = sec;
        }

        return head;
    }
}