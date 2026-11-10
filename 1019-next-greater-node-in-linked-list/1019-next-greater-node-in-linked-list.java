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
    ListNode reverse(ListNode head){
        ListNode rev = null;
        ListNode temp = head;

        while(temp != null){
            ListNode front = temp.next;
            temp.next = null;

            temp.next = rev;
            rev = temp;

            temp = front;
        }

        return rev;
    }

    public int[] nextLargerNodes(ListNode head) {
        ListNode temp = head;
        int len = 0;

        while(temp != null) {
            len++;
            temp = temp.next;
        }
        
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[len];
        temp = reverse(head);
        int ind = 0;

        while(temp != null){
            int curr = temp.val;

            // Remove smaller elements than curr to the right 
            while(!stack.isEmpty() && stack.peek() <= curr) stack.pop();

            res[len -ind -1] = stack.isEmpty() ? 0 : stack.peek();

            ind++;
            temp = temp.next;
            stack.push(curr);
        }

        return res;
    }
}