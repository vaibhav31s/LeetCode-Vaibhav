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
    public ListNode doubleIt(ListNode head) {
        ListNode last = reverseList(head);
        int extra = 0;
        int two = 2;
        ListNode ans = new ListNode();
        //9 8 1
        // 9 * 2 = 18 % 10 = 8 = 8 + extra = 8 = extra += 18 -
        ListNode lastFirst = null;
        ListNode temp = last;
    
        while (temp != null) {
            lastFirst = temp;
            int lastDigit = temp.val;
            lastDigit *= two;
            lastDigit += extra;
            temp.val = lastDigit % 10;
            extra = lastDigit / 10;
            temp = temp.next;
        }
        if (extra != 0) {
            lastFirst.next = new ListNode(extra);
        }
        
        return reverseList(last);
    }
    
    public ListNode reverseList(ListNode head) {
        ListNode last = null;
        ListNode p1 = head;
        if(p1== null) return p1;


        ListNode p2 = head.next; 
           
        while(p2 != null){
                p1.next = last;
                last = p1;
                p1 = p2;
                p2 = p2.next;
        }
     
        p1.next = last;
        return p1;
        
    }
}