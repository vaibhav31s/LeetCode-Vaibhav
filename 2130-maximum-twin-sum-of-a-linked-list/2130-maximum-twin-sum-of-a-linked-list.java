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
    public int pairSum(ListNode head) {
        if(head.next.next == null){
            return head.next.val + head.val;
        }
        
        int n = getSize(head);
        int mid = n/2;
        ListNode temp = head;
        while(mid-->1) temp = temp.next;

        ListNode bichwala = temp.next;
        temp.next = null;

        bichwala = reverse(bichwala);
        
        int answer =0;
        while(head != null){
            int a = bichwala.val;
        // System.out.println(bichwala.val);
        //             System.out.println(head.val);

            int b = head.val;
            answer = Math.max(a + b, answer);
            head = head.next;
            bichwala = bichwala.next;
        }
        
        return answer;
        
        
    }
    
     ListNode reverse(ListNode head){
        if(head == null || head.next == null) return null; 
        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode last = null;
        while(p2 != null){
            p1.next = last;
            last = p1;
            p1 = p2;
            
                p2 = p2.next;
            
        }
        p1.next = last;
        return p1;
    }
    int getSize(ListNode head){
        int n = 0;
        while(head != null){
            head = head.next;
            n++;
        }
        return n;
    }
}