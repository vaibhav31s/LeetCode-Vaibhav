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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head.next == null) return head;
        ListNode nextElement = head.next;
        ListNode curElement = head;
        while (nextElement != null) {
            int curValue = curElement.val;
            int nextValue = nextElement.val;
            int gcd = gcd(curValue, nextValue);
            insertGCD(curElement, nextElement, new ListNode(gcd));
            
            curElement = nextElement;
            nextElement = curElement.next;
        }
        
        return head;
    }
    
    void insertGCD(ListNode cur, ListNode next, ListNode toInsert) {
        cur.next = toInsert;
        toInsert.next = next;
    }
    int gcd(int a, int b) {
        if (0 == b) {
            return a;
        }
        
        return gcd(b, a % b);
    }
}