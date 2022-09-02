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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> answer = new ArrayList<>();
        Deque<TreeNode> dq= new LinkedList<>();
        dq.add(root);
        while(!dq.isEmpty()){
            int size = dq.size();
            double add = 0;
            double len = size;
            while(size--> 0 ){
                TreeNode temp = dq.poll();
                if(temp.left != null) dq.add(temp.left);
                if(temp.right != null) dq.add(temp.right);
                add+= temp.val;
            }
            
            answer.add(add/len);
            
        }
        
        
        return answer;
    }
}