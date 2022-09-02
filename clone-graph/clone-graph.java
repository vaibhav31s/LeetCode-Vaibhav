/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }
        HashMap<Integer, Boolean> vis = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> list = new HashMap<>();
        if(node == null) return new Node();
        list.putIfAbsent(node.val,new HashSet<>());
        
        dfs(node, vis, list);
        HashMap<Integer, Node> copy = new HashMap<>();
        for(int x : list.keySet()){
            copy.put(x, new Node(x));
        }
        int k = -1;
        for(int x : list.keySet()){
            if(k == -1) k =x;
            for(int y : list.get(x)){
            copy.get(x).neighbors.add(copy.get(y));
            }
        }
        return copy.get(k);
        
    }
    
   
    
    void dfs(Node node, HashMap<Integer, Boolean> vis,HashMap<Integer, HashSet<Integer>> list ){
        System.out.println(node.val);
        list.putIfAbsent(node.val, new HashSet<>());
        vis.putIfAbsent(node.val,true);
        for(Node n : node.neighbors){
           list.putIfAbsent(n.val, new HashSet<>());
         
                list.get(n.val).add(node.val);
                list.get(node.val).add(n.val);
            if(!vis.containsKey(n.val)){
                dfs(n, vis,list);
            }
        }
        
    }
}