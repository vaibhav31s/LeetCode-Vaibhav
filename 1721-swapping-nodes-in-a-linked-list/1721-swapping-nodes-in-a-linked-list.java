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
    public ListNode swapNodes(ListNode head, int k) {
        int n = getSize(head);
        int firstValue = getValue(head, k);
        int lastValue = getValue(head, n - k + 1);
        ListNode firstK = getNode(head, k);
        ListNode lastK = getNode(head, n - k + 1);
        
        // System.out.println(firstK.val + " " + lastK.val);
        firstK.val = lastValue;
        lastK.val = firstValue;
        
        return head;
        
    }
    int getValue(ListNode root, int k){
        // int value = -1;
        
        while(k-- > 1){
            root = root.next;
        }
        
        return root.val;
    }
    
    ListNode getNode(ListNode root, int k){
        // int value = -1;
        
        while(k-- > 1){
            root = root.next;
        }
        
        return root;
    }
    
    int getSize(ListNode root){
        int n = 0;
        while(root != null){
            root = root.next;
            n++;
        }
        return n;
    }
}