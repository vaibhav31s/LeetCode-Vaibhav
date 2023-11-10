class Solution {
    ArrayList<Integer> answer = new ArrayList<>();
    public int[] restoreArray(int[][] adjacentPairs) {
        
        HashMap<Integer, Pair> map = new HashMap<>();
        for (int[] adj : adjacentPairs) {
            map.computeIfAbsent(adj[0], Pair::new).add(map.computeIfAbsent(adj[1], Pair::new));
            map.computeIfAbsent(adj[1], Pair::new).add(map.get(adj[0]));
        }
        
        int start = map.keySet().stream().filter(val -> map.get(val).second == null).findFirst().orElseThrow();
        
        HashSet<Integer> vis = new HashSet<>();
        // System.out.println(start);
        
        int[] ans = new int[map.size()];
        ans[0] = start;
        vis.add(ans[0]);
        int p = 1;
        Pair temp = map.get(start).first;

        while (p < map.size() && temp != null) {
            ans[p++] = temp.val;
            vis.add(temp.val);
            temp = vis.contains(temp.first.val) ? temp.second : temp.first;
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
        
        void add(Pair p) {
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

