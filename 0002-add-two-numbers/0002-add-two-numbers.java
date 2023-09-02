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
    public ListNode addTwoNumbers(ListNode p1, ListNode p2) {
        ListNode answer = new ListNode(-1);
        ListNode pans = answer;
        int carry = 0;
        while(p1 != null || p2 != null){
            int sum = 0;
            sum += carry;
            if(p1 != null){
                sum+= p1.val;
                p1 = p1.next;
            }
            if(p2 != null){
                sum += p2.val;
                p2 = p2.next;
            }
            if(sum > 9){
                pans.next = new ListNode(sum % 10);
                carry = 1;
            }else{
                pans.next = new ListNode(sum);
                carry = 0;
            }
            pans = pans.next;
            
        }
        if(carry == 1){
            pans.next = new ListNode(1);
        }
        
        return answer.next;
        
    }
}