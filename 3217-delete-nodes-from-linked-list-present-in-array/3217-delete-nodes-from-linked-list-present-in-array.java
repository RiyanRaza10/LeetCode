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
        HashSet<Integer> set = new HashSet<>();

        for(int num : nums) set.add(num);

        ListNode ans = new ListNode(0);
        ListNode ansHead = ans;
        ListNode temp = head;

        while(temp != null){
            if(!set.contains(temp.val)){
                ListNode neww = new ListNode(temp.val);
                ans.next = neww;
                ans = ans.next;
            }

            temp = temp.next;
        }

        return ansHead.next;
    }
}