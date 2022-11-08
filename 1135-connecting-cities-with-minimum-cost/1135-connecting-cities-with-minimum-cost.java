class Solution {
    public int minimumCost(int n, int[][] logs) {
       Arrays.sort(logs, (a, b) -> a[2] - b[2]);
        UnionFind uf = new UnionFind(n+1);
        int answer =0;
        outer:
        for(int[] l : logs){
            if(uf.isConnected(l[0],l[1]))continue;
            answer += l[2];
            // if(uf.)
            uf.union(l[0], l[1]);
            for(int i = 2; i <= n; i++){
                if(!uf.isConnected(i,i-1)) continue outer;
                
            }
            return answer;
        }
        
        return -1;
    }
}

class UnionFind{
        HashMap<Integer, Integer> root;
        int[] rank;
        UnionFind(int size){
            
            root = new  HashMap<>();
            rank = new int[size];
            for(int i = 1; i < size; i++){
                root.put(i,i);
                rank[i] = 1;
            }
        }
        int find(int x){
            if(root.get(x) == x) return x;
            root.put(root.get(x), find(root.get(x)));
            return root.get(root.get(x));
        }
        boolean union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            int rankX = rank[rootX];
            int rankY = rank[rootY];
            
             if (rootX == rootY) 
                    return false;
            if(rankX >  rankY){
                root.put(rootY,rootX);
            }else if(rankX < rankY){
                root.put(rootX,rootY);
            }else{
                root.put(rootY, rootX);
                rank[rootX]++;
            }
    
            return true;
        }
    public boolean isConnected(int a, int b) {
        // Return true if both a and b belong to the same set, otherwise return false
        return find(a) == find(b);
    }
}