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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode even = null, odd = null, evenp = null, oddp = null;
        boolean flag=  false;
        while(head != null){
            
            if(flag){
                if(even == null){
                    even = head;
                    evenp= even;
                }else{
                    evenp.next= null;
                    evenp.next = head;
                    evenp = evenp.next;
                }
                
            }else{
                if(odd   == null){
                        odd = head;
                        oddp= odd;
                    }else{
                    oddp.next = null;
                    oddp.next = head;
                    oddp = oddp.next;
                }
            }
            
            
            flag=  !flag;
            head= head.next;
        }
        oddp.next = null;
        evenp.next = null;
        oddp.next= even;
        
        return odd;
    }
}
