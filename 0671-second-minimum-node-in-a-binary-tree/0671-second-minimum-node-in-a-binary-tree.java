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
    long min = Long.MAX_VALUE;
    long lastMin = 0;
    public int findSecondMinimumValue(TreeNode root) {
        go(root);
        lastMin = min;min = Long.MAX_VALUE;
        go(root);
        return min == (Long.MAX_VALUE) ? -1 : (int) min;
    }
    void go(TreeNode root) {
        if (root == null) return;
        
        go(root.left);
        go(root.right);
        if (lastMin == 0) {
            min = Math.min(min, root.val);
        } else {
            if (root.val > lastMin) {
                min = Math.min(min, root.val);
            }
        }
    }
}