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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        StringBuilder first =  new StringBuilder();
        go(root1, first);
        StringBuilder second = new StringBuilder();
        go(root2, second);
        // System.out.println(first + " " + second);
        return first.toString().equals(second.toString());
    }
    
    void go(TreeNode root, StringBuilder sb) {
          if(root == null) return;
        
          if(root.left == null && root.right == null) {
              sb.append(root.val + ",");
              return;
          }
        
        go(root.left, sb);
        go(root.right, sb);
        
    }
}