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
    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        go(root, sb);
        
        return sb.toString();
    }
    void go(TreeNode root, StringBuilder sb) {
        if(root == null) return;
            if(root.left == null && root.right == null) {
                
                return;
                
            }
        
            if(root.left != null && root.right != null) {
                sb.append('(');
                sb.append(root.left.val);
                go(root.left, sb);
                sb.append(')'); 
                sb.append('(');
                sb.append(root.right.val);
                go(root.right, sb);
                sb.append(')'); 
            } else if(root.left != null && root.right == null){
                sb.append('(');
                sb.append(root.left.val);
                go(root.left, sb);
                sb.append(')'); 
              
            }else if(root.right != null && root.left == null){
                sb.append('(');
                sb.append(')'); 
                sb.append('(');
                sb.append(root.right.val);
                go(root.right, sb);
                sb.append(')'); 
            } 
        
    }
}