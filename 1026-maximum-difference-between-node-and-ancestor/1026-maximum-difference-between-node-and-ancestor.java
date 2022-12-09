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
    int maxx = 0;
    public int maxAncestorDiff(TreeNode root) {
        
        
dfs(root, root.val, root.val);
    return maxx;        
    }
    
    
    void dfs(TreeNode cur, int min, int max){
        if(cur == null) return ;
        
         min = Math.min(min, cur.val);
         max = Math.max(max, cur.val);
        
        maxx = Math.max(maxx,Math.abs(max -min));
    
        dfs(cur.left, min, max);
        dfs(cur.right, min, max);
        
    
    }
    
    
}