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
    public ListNode removeZeroSumSublists(ListNode head) {
        int size = getSize(head);
        Pair<ListNode, Integer>[] pref = new Pair[size + 1];
        int i = 0;
        pref[i] = new Pair(head, 0);
        int prev = 0;
        long sum = 0;
        i++;
        while (head != null) {
            pref[i] = new Pair(head, head.val + pref[i-1].getValue());
      
            sum += head.val;
            head = head.next;
            i++;
        }
        
        if(sum == 0) return null;
        
        if (size == 1) return pref[0].getKey();
        
        PriorityQueue<Pair<Integer, Pair<Integer, Integer>>> pq = new PriorityQueue<>((a,b)->{
            return b.getKey() - a.getKey();
        });
        ListNode answer = null;
        
        
        for (i = 0; i <= size; i++) {
            
            for (int j = size; j > i; j--) {
                sum = pref[j].getValue() - pref[i].getValue();
                
                if (sum == 0) {
                    // System.out.println(i + " " + j);
                    if (i == 0) {
                        if (answer == null) {
                             answer = pref[j].getKey().next;
                       
                        }
                    } else {
                        if(answer == null) answer = pref[0].getKey();
                         pref[i].getKey().next = pref[j ].getKey().next;
                        if (answer == null) answer = pref[i].getKey().next;
                        
                    }
                       i = j;
                }
         
            }
            
        }
       
        
        
            if(answer == null)  return pref[0].getKey();
            if(answer.val == 0) return answer.next;
            return answer;
    }
    
    int getSize(ListNode head) {
        int count = 0;
        while (head!= null) {
            head = head.next;
            count++;
        }
        return count;
    }
}

// 1 3 0 3 4