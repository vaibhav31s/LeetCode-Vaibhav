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
    public int widthOfBinaryTree(TreeNode root) {
        Deque<TreeNode> dq = new LinkedList<>();
        HashMap<TreeNode, Long>  map = new HashMap<>();
        dq.add(root);
        map.put(root, 1L);
        // if(root.left != null) map.put(root.left, 1);
        // if(root.right != null) map.put(root.right, 2);
        long answer = 0;
        while(!dq.isEmpty()){
            int n = dq.size();
            long min =  Long.MAX_VALUE;
            long max = Long.MIN_VALUE;
            while(n-- > 0){
                TreeNode  temp = dq.poll();
                Long cur = map.getOrDefault(temp,1L);
                // if(cur != null)
                max = Math.max(max, cur);
                min = Math.min(min, cur);
                if(temp.left != null) {map.put(temp.left, (cur * 2) -1);
                                     dq.add(temp.left);}
                if(temp.right != null) {map.put(temp.right, cur * 2);
                                     dq.add(temp.right);  
                                       }
                
            }
               // System.out.println(max);
            long a = max - min;
            answer = Math.max((a)+1,answer);
        }
     
    return (int)answer;
    }
}