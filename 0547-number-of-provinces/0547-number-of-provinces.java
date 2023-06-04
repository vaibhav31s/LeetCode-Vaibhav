class Solution {
    public int findCircleNum(int[][] isConnected) {
        DSU dsu  = new DSU(isConnected.length+1);
        for(int i = 1; i < isConnected.length+1; i++){
            int[] x =  isConnected[i-1];
            for(int j = 1; j < x.length+1; j++){
                if(isConnected[i-1][j-1] == 1)
                dsu.merge(i, j);
                
            }
        }
        
        HashSet<Integer> answer = new HashSet<>();
        for(int i = 1; i <= isConnected.length; i++){
            answer.add(dsu.find(i));
        }
        return answer.size();
        
    }
        private static class DSU
    {
        public int[] dsu;
        public int[] size;
    
        public DSU(int N)
        {
            dsu = new int[N+1];
            size = new int[N+1];
            for(int i=0; i <= N; i++)
            {
                dsu[i] = i;
                size[i] = 1;
            }
        }
        //with path compression, no find by rank
        public int find(int x)
        {
            return dsu[x] == x ? x : (dsu[x] = find(dsu[x]));
        }
        public void merge(int x, int y)
        {
            int fx = find(x);
            int fy = find(y);
            dsu[fx] = fy;
        }
        public void merge(int x, int y, boolean sized)
        {
            int fx = find(x);
            int fy = find(y);
            size[fy] += size[fx];
            dsu[fx] = fy;
        }
    }
}