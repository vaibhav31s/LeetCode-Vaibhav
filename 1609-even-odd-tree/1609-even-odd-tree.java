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
    public boolean isEvenOddTree(TreeNode root) {
        Deque<TreeNode> dq = new LinkedList<>();
        dq.add(root);
        int level = 0;
        while (!dq.isEmpty()) {
            
            int size = dq.size();
            
            boolean isEven = (level % 2) == 0;
            
            int cur = !isEven ? dq.peek().val + 1 : dq.peek().val - 1;
            
            while (size-- > 0) {
                TreeNode curNode = dq.poll();
                if (isEven) {
                    
                    if (cur >= curNode.val || curNode.val % 2 == 0)  return false;
                } else {
                    if (cur <= curNode.val || curNode.val % 2 != 0)  return false;
                }
                
                cur = curNode.val;
                if (curNode.left != null) dq.add(curNode.left);
                if (curNode.right != null) dq.add(curNode.right);
            }
            
            level++;
        }
        
        return true;
    }
}