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
    int K = 0;
    int ans = 0;
    public int kthSmallest(TreeNode root, int k) {
        K = k;
         go(root, k);
        
        return ans;
    }
    
    int go(TreeNode root, int k) {
        if (root == null) return -1;
        
        go(root.left, k - 1);
        K--;
        if (K == 0) {
            ans = root.val;
        }
        go(root.right, k);
        
        return -1;
    }
    
}