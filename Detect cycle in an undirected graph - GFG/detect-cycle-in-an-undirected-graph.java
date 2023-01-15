//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
          HashMap<Integer,ArrayList<Integer>>  g =  new HashMap<>();
        int i = 0;
        for(ArrayList<Integer> list : adj){
            g.put(i, list);
            i++;
        }
        boolean ans = issCycle(g);
        return ans;
    }
    

private  boolean issCycle(HashMap<Integer, ArrayList<Integer>> graph) {
        HashSet<Integer> vis = new HashSet<>();

        for(Integer k :graph.keySet()){
            if(!vis.contains(k)) {

                if (isCycle(k, graph, vis,Integer.valueOf("-1"))) {

                    return true;
                }
            }
        }
return false;
    }

    private  boolean isCycle(Integer cur, HashMap<Integer, ArrayList<Integer>> graph, HashSet<Integer> vis, Integer parent) {
        vis.add(cur);

        for(Integer k : graph.get(cur)){
           if(!vis.contains(k)){

               if(isCycle(k, graph, vis,cur)){
                   return true;
               }
           }else

           if(!k.equals(parent)) return true;

        }

        return false;

    }

}