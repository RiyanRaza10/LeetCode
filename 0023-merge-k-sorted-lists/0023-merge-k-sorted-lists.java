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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null) return null;

        ListNode ans = null;

        for(ListNode l : lists){
            ans = merge(ans , l);
        }

        return ans;
    }

    ListNode merge(ListNode list1 , ListNode list2){
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        ListNode ans = null;

        // Assign first node
        if(list1.val <= list2.val){
            ans = list1;
            list1 = list1.next;
            ans.next = null;
        }
        else{
            ans = list2;
            list2 = list2.next;
            ans.next = null;
        }

        ListNode ansHead = ans;

        // Merge
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                ans.next = list1;
                ans = ans.next;
                list1 = list1.next;
                ans.next = null;
            }

            else{
                ans.next = list2;
                ans = ans.next;
                list2 = list2.next;
                ans.next = null;
            }
        }

        // Handle bache hue part of list1 or list2
        if(list1 != null) ans.next = list1;
        else if(list2 != null) ans.next = list2;

        return ansHead;
    }
}