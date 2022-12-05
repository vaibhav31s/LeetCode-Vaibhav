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
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        if(head.next == null) return head;
        ListNode fast = head.next;
        
        while(fast != null){
            
            
            
            slow = slow.next;
            if(fast.next == null) break;
            fast = fast.next.next;
        }
        
        return slow;
    }
}