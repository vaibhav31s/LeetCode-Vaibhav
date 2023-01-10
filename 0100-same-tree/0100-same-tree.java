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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        
        write(p, s1);
        write(q,s2);
        return s1.toString().equals(s2.toString());
    }
    
    void write(TreeNode p, StringBuilder sb){
        if(p ==null){
            sb.append('*'+",");
        return;
        }
        sb.append(p.val+",");
        write(p.left, sb);
        write(p.right, sb);
    }
}