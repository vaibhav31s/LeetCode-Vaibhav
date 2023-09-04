/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode slow = head;
        if(slow.next == null) return false;
        ListNode fast = head.next;
        
        while(slow != null && fast != null) {
            if(slow == fast) return true;
            slow = slow.next;
            if(fast.next == null || fast.next.next == null) return false;
            fast = fast.next.next;
        }
        
        
        
        return false;
    }
}