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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int n = getTotalNodes(head);
        ListNode[] answer = new ListNode[k];
  
        int total = n / k; 
        int i = 0;
       
        while ( i < answer.length) {
            boolean flag = n % k != 0 ? false : true;
            
            answer[i] = head;
            ListNode last = head;
            total = n / k;
            if (!flag) {
              
               total++;
        
            }
            n -= total;
            k--;
            for(int j = 0; j < total; j++) {
                if(head == null) continue;
                last = head;
                head = head.next;
            }
            if(last != null) {
                last.next = null;
            }
            
            
            i++;
        }
        if(i < answer.length)
            answer[i] = head;    
        return answer;
        
    }
    
    
    int getTotalNodes(ListNode head) {
        int cnt = 0;
        while (head != null) {
            head = head.next;
            cnt++;
        }
        return cnt;
    }
}