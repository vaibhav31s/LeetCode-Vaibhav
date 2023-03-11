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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        ArrayList<Integer> nums = new ArrayList<>();
        while(head != null){
            nums.add(head.val);
            head = head.next;
        }
        int start = 0;
        int end = nums.size() - 1;
        return divide(nums, start, end);
    }
    
    
    TreeNode divide(ArrayList<Integer> nums, int start, int end){
        if(start > end) return null;
        int mid = (start + end)/2;
        
        TreeNode m = new TreeNode(nums.get(mid));
        m.left = divide(nums, start, mid - 1);
        m.right = divide(nums, mid + 1, end);
        return m;
    }
}