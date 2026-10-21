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
    public ListNode modifiedList(int[] nums, ListNode head) {
        int max = -1;

        for(int num : nums) max = Math.max(num , max);

        int[] freq = new int[max+1];

        for(int num : nums) freq[num]++;

        ListNode ans = new ListNode(0);
        ListNode ansHead = ans;
        ListNode temp = head;

        while(temp != null){

            if(temp.val <= max && freq[temp.val] == 0){
                ListNode neww = new ListNode(temp.val);
                ans.next = neww;
                ans = ans.next;
            }

            else if(temp.val > max){
                ListNode neww = new ListNode(temp.val);
                ans.next = neww;
                ans = ans.next;
            }

            temp = temp.next;
        }

        return ansHead.next;
    }
}