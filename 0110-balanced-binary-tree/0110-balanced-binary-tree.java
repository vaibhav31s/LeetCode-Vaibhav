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
    boolean answer = true;
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        go(root);
        return answer;
    }
    int go(TreeNode root) {
        if (root == null) return 0;
        
        int left = go(root.left);
        int right = go(root.right);
        if (Math.abs(left - right) > 1) {answer = false;}
        return 1 + Math.max(left, right);
    }
}