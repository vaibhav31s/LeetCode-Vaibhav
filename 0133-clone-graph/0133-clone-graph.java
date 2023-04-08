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
        HashMap<Integer,Node> nMap = new HashMap<>();
        if(node == null) return null;
        Node root = node;
        Set<Integer> vis = new HashSet<>();
        Deque<Node> dq = new LinkedList<>();
        vis.add(root.val);
        dq.add(node);
        while(!dq.isEmpty()){
            
            int n = dq.size();
            while(n-- > 0){
                Node p = dq.poll();
                nMap.put(p.val, p);
                for(Node ps :  p.neighbors){
                    if(!vis.contains(ps.val))
                                 dq.add(ps);
                }
                vis.add(p.val);
            }
            
        }
        // System.out.println(nMap);
        
        
        HashMap<Integer,Node> newMap = new HashMap<>();
        for(int x : nMap.keySet()){
            newMap.put(x, new Node(x));
        }
        
        for(int x : nMap.keySet()){
            List<Node> a = nMap.get(x).neighbors;
            List<Node> b = new ArrayList<>();
            for(Node n :  a){
                b.add(newMap.get(n.val));
            }
            newMap.get(x).neighbors = b;
            
        }
        // System.out.println(newMap);
        
        
        
        
        return newMap.get(node.val);
        
    }
}