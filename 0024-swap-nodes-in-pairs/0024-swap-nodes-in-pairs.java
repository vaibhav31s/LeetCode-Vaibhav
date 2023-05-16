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
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
         boolean isHead = true;
        ListNode p1 =head;
        ListNode p2 =p1.next;
        ListNode last = null;
        while(p1!=null) {
            if(isHead){
                p2= p1.next;
                p1.next =p2.next;

                p2.next = p1;
                head=p2;
                isHead= false;
                last = p1;
            }else{
                p2= p1.next;
                if(p2==null){
                   return head;
                }else{
                    p1.next =p2.next;
                    last.next = p2;
                    last = p1;
                    p2.next = p1;
                }
            }
            p1 = p1.next;
        }
        return head;
    }
}