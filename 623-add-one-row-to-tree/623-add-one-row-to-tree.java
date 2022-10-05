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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        
        if(depth == 1){
            TreeNode main = new TreeNode(val);
            main.left = root;
            return main;
        }
        
        
        if(root == null){
            if(depth - 1 == 1){
                
               
              
            }
            return root;
        }
            
        
        
        if(depth - 1 == 1){
            if(root.left != null){
                TreeNode ltemp = root.left;
                root.left = new TreeNode(val);
                root.left.left = ltemp;
          
                
            }else{
                 root.left = new TreeNode(val);
             
           
              
              
            }
            if(root.right != null){
               TreeNode ltemp = root.right;
                root.right = new TreeNode(val);
                root.right.right = ltemp;
             
                
            }else{
                  root.right = new TreeNode(val);
            }
            
        }
        
        addOneRow(root.left, val, depth  - 1);
        
        addOneRow(root.right, val, depth  - 1);
        
        
        return root;
    }
}