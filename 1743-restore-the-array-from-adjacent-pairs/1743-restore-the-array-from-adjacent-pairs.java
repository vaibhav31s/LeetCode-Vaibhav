class Solution {
    ArrayList<Integer> answer = new ArrayList<>();
    public int[] restoreArray(int[][] adjacentPairs) {
        
        HashMap<Integer, Pair> map = new HashMap<>();

        for (int[] adj : adjacentPairs) {
            
            map.putIfAbsent(adj[0], new Pair(adj[0]));
            map.putIfAbsent(adj[1], new Pair(adj[1]));

            map.get(adj[0]).Add(map.get(adj[1]));
            map.get(adj[1]).Add(map.get(adj[0]));
            
        }
        
        
        
        int start = 0;
        for (int val : map.keySet()) {
            if(map.get(val).second == null) {
                start = val;
                break;
            }
        } 
        
        HashSet<Integer> vis = new HashSet<>();
        // System.out.println(start);
        
        int[] ans = new int[map.size()];
        ans[0] = start;
        vis.add(ans[0]);
        int p = 1;
        Pair temp = map.get(start).first;
        while(p < map.size()) {
            ans[p++] = temp.val;
            vis.add(temp.val);
            Integer f = temp.first.val;
            
            if(temp.second == null) break;
            Integer s = temp.second.val;
            
            
            if(!vis.contains(temp.first.val)) {
                temp = temp.first;
            } else {
                temp = temp.second;
            }
        }
        
        return ans;
    }
    
    private class Pair { 
        int val;
        Pair first;
        Pair second;
        int counter = 0;
        Pair(int val) {
            this.val = val;
        }
        
        void Add(Pair p) {
            if(counter == 0) {
                first = p;
                counter++;
            } else {
                second = p;
            }
            
        }
        public String toString() {
              return " First Value: " + first.val + "  Second Value : " +((second == null) ? "null " :   second.val+" ");
        }
    }
    

    
    
    
}

