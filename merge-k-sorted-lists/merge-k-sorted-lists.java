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
        if (lists.length == 0) return null;
        ListNode ans = lists[0];
        for (int i = 1; i < lists.length; i++) {
            ans = mergeTwoLists(ans, lists[i]);
        }
        return ans;
    }
    
    
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ans = new ListNode();
        ListNode tempAns = ans;
        ListNode p1 = list1, p2 = list2;
        while (p1 != null && p2 != null) {
            int valAtP1 = p1.val;
            int valAtP2 = p2.val;
            if (valAtP1 <= valAtP2) {
                ans.next = p1;
                p1 = p1.next;
                ans = ans.next;
            } else {
                ans.next = p2;
                p2 = p2.next;
                ans = ans.next;
            }
        }
        
        if (p1 == null) {
            ans.next = p2;
        } else {
            ans.next = p1;
        }
        
        return tempAns.next;
    }
}