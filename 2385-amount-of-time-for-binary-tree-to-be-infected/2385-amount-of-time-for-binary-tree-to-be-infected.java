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
    int count = 0;
    public int amountOfTime(TreeNode root, int start) {
        List<List<Integer>> answer = new ArrayList<>();
        int max = 0;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        HashMap<Integer, Boolean> visited = new HashMap<>();
        if(root == null) return 0;
        Deque<TreeNode> dq = new LinkedList<>();
        dq.push(root);
         List<List<Integer>> l = new ArrayList<>();
        
        while(!dq.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size =  dq.size();
            while(size-- > 0){
                TreeNode temp = dq.poll();
                map.putIfAbsent(temp.val,new ArrayList<>());
                list.add(temp.val);
                visited.putIfAbsent(temp.val, false);
                    
                if(temp.left != null){
                    dq.offer(temp.left);
                    map.putIfAbsent(temp.left.val,new ArrayList<>());
                    map.get(temp.val).add(temp.left.val);
                    map.get(temp.left.val).add(temp.val);     
                    visited.putIfAbsent(temp.left.val, false);
                    
                }
                if(temp.right != null){
                    dq.offer(temp.right);
                 map.putIfAbsent(temp.right.val,new ArrayList<>());
                     map.get(temp.val).add(temp.right.val);
                    map.get(temp.right.val).add(temp.val);
                    visited.putIfAbsent(temp.right.val, false);
                    
                }
            }
            answer.add(list);
            
        }
        
        Deque<Integer> deq = new LinkedList<>();
        deq.push(start);
        visited.put(start, true);
        while(!deq.isEmpty()){
            
            int size = deq.size();
            while(size-- > 0){
                int temp = deq.poll();
                for(int X : map.get(temp)){
                    if(!visited.get(X)){
                        visited.put(X, true);
                        deq.add(X);
                    }
                }
            }
            count++;
            
        }
       
        
        return count-1;
    }
    
   
}